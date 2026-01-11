package http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelHttpRequestsSender {

    private static final String WEB_SITE = "http://www.google.com";
    private static final int PARALLEL_REQUESTS = 100;

    public long executeRequestsSync(HttpClient httpClient, HttpRequest httpRequest) throws Exception {

        long startTime = System.currentTimeMillis();

        // send is a blocking method and the thread will stop executing until the server has returned response
        for(int i = 0; i < PARALLEL_REQUESTS; i++) {
            httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
        }

        return System.currentTimeMillis() - startTime;
    }

    public long executeRequestsAsync(HttpClient client, HttpRequest request) {
        List<CompletableFuture<String>> futures = new ArrayList<>();

        // send some asynchronous requests and measure time
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < PARALLEL_REQUESTS; i++) {
            // sendAsyc method is non blocking, it will continue with the iteration
            // the method sendAsyc returnes CompletableFuture that ensures that in the future we will receive data
            // thenApply method specifies what to happen when the response is received
            futures.add(client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(x -> {
                System.out.println("thenApply() thread: " + Thread.currentThread().getName());
                return x.body();
            }));
        }

        // wait for all futures to complete
        for(int i = 0; i < futures.size(); i++) {
            futures.get(i).join();
        }

        // alternativly you can use this
        // CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            HttpClient client =
                    // if we do not point out the executor, Java will gives us the default executor
                    HttpClient.newBuilder().executor(executor).build(); // configure custom executor or use the default

            // build a request
            HttpRequest request =
                    HttpRequest.newBuilder()
                    .uri(URI.create(WEB_SITE))
                    .build();

            var sender = new ParallelHttpRequestsSender();

            long syncExecutionTime = sender.executeRequestsSync(client, request);
            long asyncExecutionTime = sender.executeRequestsAsync(client, request);

            System.out.println("Async: " + asyncExecutionTime + " Sync: " + syncExecutionTime);

            // ExecutorService is AutoCloseable since Java 19, so its shutdown() method will be automatically invoked.
        }
    }

}
