
// methods used for creation of a file 
File absoluteFile = new File("c:\\Users\\joe\\file.txt"); // creating using absolute path
File absoluteFile2 = new File("c:\\Users\\joe", "file.txt"); // file.txt is given as a String, Java automatically appends them
File parentFile = new File("c:\\Users\\joe"); 
File absoluteFile3 = new File(parentFile, "file.txt"); // file created as passed parerntFile

//URI stands for Unique Resources Identifier, contains path to a file
URI fileUri = URI.create("file:///home/joe/file.txt");
File absoluteFile4 = new File(fileUri); // opening the file with the URI

// conversion to and from java.nio.file.Path
Path absolutePath = absoluteFile.toPath(); // takes file's path and stores it in Path object
File absoluteFile = absolutePath.toFile(); // takes the path and returns a file 

long size(Path path) // returns the size of the file in bytes

boolean isRegularFile(Path path) // checks if it a normal file, in other words not a directory
boolean isDirectory(Path path) // checks if it is a directory
boolean isSymbolicLink(Path path) // checks if it a symbolic link
boolean isHidden(Path path) // checks if it is hidden


FileTime getLastModifiedTime(Path path) // returns the time in which the file was last modified
FileTime setLastModifiedTime(Path path, FileTime time) // sets the last modified time

UserPrincipal getOwner(Path path) // returns the owner of the ifle

Object getAttribute(Path path, String attribute) // gets specific attribute in its name, for example size, creation time
Path setAttribute(Path path, String attribute, Object value) // sets a value to a givven attribute

boolean exists(Path path) // checks if the file exists or directory exists
boolean isReadable(Path path) // checks if doesnt exists the file or directory
boolean isWritable(Path path) // checks if the program has right to write in the file
boolean isExecutable(Path path) // checks if the program has right to read in the file
boolean isSameFile(Path path1, Path path2) // checks if the files are the same

//try to delete a file or directory
void delete(Path path)
//throws NoSuchFileException if the file doesnt exists
//throws DirectoryNotEmptyException if we try to delete not empty directory

//tries to delete a file but a safer version
boolean deleteIfExists(Path path)
//if the file doesnt exists simply false is returned, if it was deleted it returns true
//although it returns DirectoryNotEmptyException exception if the directory is not empty 

//method to copy files and directories 
//source means what to copy, target is the destionation of the copy
//options change the behevaiour of the coping 
//StandartCopyOption.REPLACE_EXISTING: if the target exists it is going to be overriden, if it doesnt exists without it FileAlreadyExistsException is thrown
//StandartCopyOption.COPY_ATTRIBUTES: copies not only the conect of the but its attributes as well such as data of the last modification
//Note: this doesnt copies the content of a directory, if source is a directory in target a new source directory is going to be created but an empty one
Path copy(Path source, Path target, CopyOption... options);


//this method is used to move or rename files or directories 
// if source and target are in the same directory the file gets renamed
// StandardCopyOption.REPLACE_EXISTING: if target already exists this option will override him, without it we are going to have exception
// StandardCopyOption.ATOMIC_MOVE: tries to move the files with one atomoic operation but if it fails throws exception
Path move(Path source, Path target, CopyOption... options)

//creates directory at dir, will throw exception if some of the parent directories doesnt exists
Path createDirectory(Path dir);

//creates directories at dir, even if one of the parent directories doesnt exists it will create a new one
Path createDirectories(Path dir);


Path dir = Path.of("/somedir");
//Directory stream is not I/O stream reather than Collection which contains all the directories
try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) { // returns new DirectoryStream

    //itererates through all the files and directories
    for(Path fileOrSubDir : stream) {
        // some logic with fileOrSubDir
    }
}


//DirectoryStream<Path> newDirectoryStream(Path dir, String glob) takes a glob which is a templete for search
Path dir = Path.of("/somedir");
//here DirectoryStream will hold every file that ends with java extension
try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.java")) {
    // [...]
}




//Тhese are suiotable for small files, fo r larger ones, use buffered streams 
byte[] readAllBytes(Path file); //reads the entire file and return its content as a array of bytes
List<String> readAllBytes(Path file, Charset cs); // reads the entire txt file and returns its content as List<String> 

Path write(Path file, byte[] bytes, OpenOption... options); // write the entire byte[] into the file 
Path write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options); //write the entire string into the file

// Read/write entire file into a String: since Java 11
String readString(Path file); 
String readString(Path file, Charset cs);

Path writeString(Path file, CharSequence lines, OpenOption[] options); // UTF-8
Path writeString(Path file, CharSequence lines, Charset cs, OpenOption[] options); //write the entire string into the file