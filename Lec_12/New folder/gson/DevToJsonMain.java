package gson;

import com.google.gson.Gson;

public class DevToJsonMain {

    public static void main(String[] args) {
        Developer dev = new Developer("Koki", 24, "Visteon");
        DevManager manager = new DevManager("deni", "aitoski department", 4);

        // creating the json using the builder pattern
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

        // converts to json
        String devJson = gson.toJson(dev);
        String managerJson = gson.toJson(manager);

        // outputting the json
        System.out.println(devJson);
        System.out.println(managerJson);
    }
}
