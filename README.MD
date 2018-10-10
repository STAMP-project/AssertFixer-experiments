# Virtual File System
| Travis | TeamCity Linux | TeamCity Windows | Sonar | Coverage |
| :----: | :------------: | :--------------: | :---: | :------: |
| [![Travis Build Status](https://travis-ci.org/dimyriy/vfs.svg?branch=master)](https://travis-ci.org/dimyriy/vfs) | [![TC Linux Build Status](http://teamcity-ddf620d11e.westeurope.cloudapp.azure.com/app/rest/builds/buildType:(id:Vfs_LinuxBuild)/statusIcon)](http://teamcity-ddf620d11e.westeurope.cloudapp.azure.com/viewType.html?buildTypeId=Vfs_LinuxBuild&guest=1) | [![TC Windows Build Status](http://teamcity-ddf620d11e.westeurope.cloudapp.azure.com/app/rest/builds/buildType:(id:Vfs_WindowsBuild)/statusIcon)](http://teamcity-ddf620d11e.westeurope.cloudapp.azure.com/viewType.html?buildTypeId=Vfs_WindowsBuild&guest=1) | [![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=org.dimyriy:vfs&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.dimyriy:vfs) | [![Coverage Status](https://coveralls.io/repos/github/dimyriy/vfs/badge.svg?branch=master)](https://coveralls.io/github/dimyriy/vfs?branch=master) |

## Description
This project is a completely concurrent implementation of a transactional FAT FileSystem that stores all the data in one real file on disk.

## Usage
### Creating and loading the StorageFileSystem 
Entry point to create `StorageFileSystem` is the `InfileFileSystemFactory` class. It provides factory methods to different use cases.
- Create new StorageFileSystem: 
  ```java
  final InfileFileSystem fs = InfileFileSystemFactory.getInstance().createNewFileSystem("/tmp/fs/", "infile.vfs", numberOfClusters);
  ```
- Following snippet shows how to load existing StorageFileSystem from a file.
 Note that filesystem writes its lock into the file on disk, so if java process exited abnormally or if StorageFileSystem is not closed after it's being 
 used, this lock will still be written in the file. The initialization behaviour in that case is controlled by the boolean flag that says to the initializer 
 whether to fail or to forcibly unlock locked StorageFileSystem in the factory:
  ```java
  final InfileFileSystem fs = infileFileSystemFactory.loadFileSystemFromFile(Paths.get("/tmp/fs/"), "infile.vfs", false /*whether to unlock forcibly*/);
  ``` 
### Open an existing file or a directory descriptor
Note that all the descriptors should be closed after usage, so it's better to wrap the usage in try-with-resources:
```java
StoragePath directoryPath = fs.createPath("/directory");
try(StorageDirectoryDescriptor directory = (StorageDirectoryDescriptor) directoryPath.open()) {
  //do something with directory
}
```

### Creating a new file or a directory
Note that created descriptor should also be closed, so even if the descriptor is not intended to be used after creation, it's still better to wrap the creation 
itself in try-with-resources:
```java
StoragePath directoryPath = fs.createPath("/directory");
try(StorageDirectoryDescriptor directory = (StorageDirectoryDescriptor) directoryPath.open()) {
  try(StorageFileDescriptor file = directory.createChildFile("file")) {
    
  }
}
```

### Writing/reading content of the file
Writing and reading content of the file should be done only on open descriptors. Descriptor is open right after the creation or invocation of StoragePath
.open().
 - Read/write content non-buffered:
  ```java
  try(StorageFileDescriptor file = (StorageFileDescriptor) fs.createPath("/directory/file").open()) {
    file.write(byteArray);
    byte[] content = file.read();
  }
  ```
 - Append content to the end of file (buffered write):
  ```java
    try(StorageFileDescriptor file = (StorageFileDescriptor) fs.createPath("/directory/file").open()) {
      while(someContentSupplier.hasContent()) {
        byte[] chunk = someContentSupplier.getChunk();
        file.append(chunk);
      }
    }
  ```
 - Buffered read:
 ```java
  try(StorageFileDescriptor file = (StorageFileDescriptor) fs.createPath("/directory/file").open()) {
    byte[] buffer = new byte[1024];
    int remainingContent = file.size()
    while(remainingContent > 0) {
      file.readAtOffsetToBuffer(offset, Math.max(1024, remainingContent), buffer);
      //do something with buffer
      remainingContent -= 1024;
    }
  }
  ```

### Deleting a file or a directory:
```java
  try(StorageFileDescriptor file = (StorageFileDescriptor) fs.createPath("/directory/file").open()) {
    file.delete();
  }
```

### Renaming a file or a directory:
```java
  try(StorageFileDescriptor file = (StorageFileDescriptor) fs.createPath("/directory/file").open()) {
    file.rename("newName");
  }
```

### Additional usecases
For additional usecases, please, see the test cases in the project.

### Limitations
 - There's a limitation on a number of files and directories that can be stored in one directory. The number of directory children is limited to 
`clusterSize/headerSize`. `headerSize` is a size of an `entryHeader` that contains all the metadata related to the directory entry such as modification 
timestamp, filename etc. The size of an `entryHeader` is 32 bytes which leads to the hard limit of 128 directory entries with the default `clusterSize` of 4KB.
 - The file itself can have a maximum size of `Integer.MAX_VALUE` as long as there's enough space in `StorageFileSystem` to store that file.
 - Filenames are limited to 11 ascii characters.