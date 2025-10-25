//will read the contest of the file byte by byte 
InputStream InputStream = new FileInputStream("c:\\data\\input-text.txt");

int data ;

//here read will return us one byte from the file and data will be stored to data (its value is going to be from 0 to 255)
//if the method returns -1 it means we have reach the end of the file
while((data = inputStream.read()) != -1) {

    //doSomethingWithData(data)

}

//closing the stream to release the taken resources
inputStream.close();