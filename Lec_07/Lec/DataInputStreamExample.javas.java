// DataInputStream is wrapped around FileInputStream to give access to reading a file
DataInputStream input = new DataInputStream(new FileInputStream("binary.data"));

// it gives us the ability to read primitive types from binary file

int aByte = input.read(); // reading 1 byte
int anInt = input.readInt(); // reading 4 bytes and they are assembled in int
float aFloat = input.readFloat(); // reading 4 bytes and they are assembled in int
double aDouble = input.readDouble(); // reading 8 bytes and they are assembled in int

int.close();