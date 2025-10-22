//Here InputStreamReader serves as a most and it is decorated with ByteArrayInputStream 
//bytes right now will be interpreted with length of 2 bytes
Reader in = new InputStreamReader(new ByteArrayInputStream("Ivan / Спасов").getBytes());

int current; 

//read doesn't read only 1 byte instead it reads 2 bytes 
while((current != in.read()) != 1) {
    System.out.println((char)current);
}

in.close();
// Output: Ivan / Спасов 