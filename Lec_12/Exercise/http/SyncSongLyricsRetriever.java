package http;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

record LyricsResponse(String lyrics) {}

public class SyncSongLyricsRetriever {

    // the public web api returns data in json, we need this to convert to class from json
    private static final Gson GSON = new Gson();

    // the communication happens using HTTP, so HTTP_CLIENT is a class that communicates to the web api
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();

    public String getLyricsReply(String artist, String song) throws Exception {
        // the online resource is found on this uri
        URI uri = new URI("https", "api.lyrics.ovh",  "/v1/" + artist + "/" + song, null);
        System.out.println(uri);

        // creating the request
        HttpRequest request = HttpRequest.newBuilder(uri).build();

        // the request is send to the server and the server returns us a json
        // this method is a blocking one, the code will stop working until there is a response
        // When the server returns the resource it will return a stream of bytes HttpResponse.BodyHandlers.ofString() tells
        // transfrom me this stream of bytes into a string
        // .body just returns the content of the resource without http response code or headers
        String json = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();

        // converting the json to a class and then outputs the lyrics
        LyricsResponse response = GSON.fromJson(json, LyricsResponse.class);
        return response.lyrics();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new SyncSongLyricsRetriever().getLyricsReply("Crush40", "Free"));
    }
}
