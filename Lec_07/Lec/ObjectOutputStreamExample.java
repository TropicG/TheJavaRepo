var objectOutputStream = new ObjectOutputStream(new FileOutputStream("persons.data"));
// creating ObjectOutputStream that has a wrapper FileOutputStream 

// in this example we expect to read Person object from person.dat file
// In order for this to work Person needs to implements Serializable
Person object = new Person();

// instead to write the btes of the object one by one, we write the whole object
objectOutputStream.writeObject(object);

objectOutputStream.close();
