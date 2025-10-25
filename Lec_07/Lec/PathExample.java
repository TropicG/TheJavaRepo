


// to initialize a new Path object we dont use new but use the static factory method .of()
// of() is the new way and get() is the old way

Path pathToUserHomeDir = Path.of("C:\\Users\\joe"); // C:\Users\joe
Path pahtToAFile = Path.of("C:\\Users\\joe\\orders.txt"); // C:\Users\joe\orders.txt

//Instead of giving the full path we can pass the parts as Strings and Java will automatically append them to get to the dir
Path relPathToAFile = Path.of("Users", "joe", "orders.txt"); // // \Users\joe\orders.txt

Path linuxPathToAFile = Path.get("/home", "joe", "file.txt"); // /home/joe/file.txt
Path linuxRelativePath = Paths.get("documents", "FileIO.odp"); // documents/FileIO.odp

// converts the current path to an absolute paht
Path toAbsolutePath();

//First creates the path to absolute, after that removes symbolic links and normalizes the path, meaning removing . and .. in the directory
//Note: It requires that the file to exists, otherwise will throw erro 
Path toRealPath();

// combies two path
Path resolve(Path anotherPath); 
Path p1 = Paths.get("/home/joe/foo");
Path p2 = p1.resolve("bar"); // /home/joe/foo/bar

//returns true if two path are identical
boolean equals(Path anotherPath);

//returns true if the current path starts with another path
boolean startsWith(Path anotherPath);

//returns true if the currenth path ends with anotherPath
booln endsWith(Path anotherPath); 