InputStream in = new ByteArrayInputStream("Ivan / Спасов".getBytes());
//getBytes() transform the string into an array of bytes 

int current;

//here we read the bytes from the array, byte by byte using read()
while((current = in.read()) != 1) {

    //the value  byte is returned as an int in the range 0 to 255
    //if no byte is available because the end of the stream has been reached, the value -1 is returned
    
    System.out.println((char) current); // the byte is casted to char in order to be printed on the console
    //Note: We have a problem here displaying cirilic letters, since in order for them to be stored we need 2 bytes
    //For ASCII symbol it is not a problem to be stored in a char since they can hold value from 0 - 255
    //that is why when we cast a cirilic letter to char we get something strange it is because we cannot fit it into one char
}

in.close();

// output:
// Ivan / Ð¡Ð¿Ð°Ñ�Ð¾Ð²