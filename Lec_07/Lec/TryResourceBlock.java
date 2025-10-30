static String readFirstLineFromFile(String path) throws IOException {

    //whatever is declared in the brackets in the try, .close will be called after exiting the try block
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        return br.readLine();
    }
}