InputStream inputStream = new FileInputStream("c:\\data\\input.txt");

int data;
while ((data = inputStream.read()) != -1) {
    // doSomethingWithData(data);
}

inputStream.close();