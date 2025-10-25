OutputStream os = new FileOutputStream("test.txt"); 
//Note: if the file doesnt exits Java will create it 
//Note: if the file exists, its data is going to be deleted

os.write("Hello FMI!".getBytes()); // bytes are written to the buffer
os.flush(); // the bytes written in the buffer are sent to test.txt
os.close();