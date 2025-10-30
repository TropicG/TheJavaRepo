Iterable<FileStore> partitions = FileSystems.getDefault().getFileStores();
for (FileStore fs : partitions) {
    System.out.println("Partition: " + fs.name());
    System.out.println("Total space: " + fs.getTotalSpace());
    System.out.println("Unallocated space: " + fs.getUnallocatedSpace());
    System.out.println("Usable space: " + fs.getUsableSpace());
}