# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 5 : File Handling and JDBC

- [x] ~~Java File Handling~~
- [x] ~~Java Streams~~
- [ ] Java Database Connectivity

### Java File Handling

- File : named location that stores related information.
- A directory is a collection of files and subdirectories.
- A directory inside a directory is known as subdirectory.
- To create an object of File, we need to import the `java.io.File` package first.
- Once we import the package, here is how we can create objects of file.

```java
// Read character by character from the file.
import java.io.BufferedReader;
import java.io.BufferedWriter;

// Opens the file for reading and writing.
import java.io.FileReader;
import java.io.FileWriter;

// Exception
import java.io.IOException;

public class FileHandling {
  public static void main(String[] args) throws IOException {
    // Create a buffered writer to write to the file.
    BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));

    // Write the contents to the file.
    bw.write("Apple\n");
    bw.write("Bethesda\n");
    bw.write("Corsair\n");

    // Read the contents of the file
    BufferedReader br = new BufferedReader(new FileReader("file.txt"));

    // Output the contents
    String temp;

    // Print the file's contents
    while ((temp = br.readLine()) != null) {
      System.out.println(temp);
    }


    bw.close();
    br.close();
  }
}
```

## Java Streams

- Java provides a new additional package in Java 8 called `java.util.stream`.
- This package consists of classes, interfaces and enum to allows functional-style operations on the elements.
- You can use stream by importing `java.util.stream` package.
- Stream does not store elements.
- It conveys elements from a source through a pipeline of operations.
- Stream is functional in nature.
- Operations performed on a stream does not modify it's source.
- Filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
- Stream is lazy and evaluates code only when required.
- The elements of a stream are only visited once during the life of a stream.
- Like an Iterator, a new stream must be generated to revisit the same elements of the source.

### Filtering the elements using Stream

```java
import java.util.stream.*;
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Declare the array list
    ArrayList<Integer> arr = new ArrayList<>();

    // Add the following numbers
    arr.add(40);
    arr.add(10);
    arr.add(30);
    arr.add(50);
    arr.add(20);

    // Create a list of items by filtering
    List<Integer> arr2 = arr.stream().filter(num -> num > 30).collect(Collectors.toList());

    for (Integer integer : arr2) {
      System.out.println(integer);
    }
  }
}
```

### Sorting using streams

```java
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Declare the array list
    ArrayList<Integer> arr = new ArrayList<>();

    // Add the following numbers
    arr.add(40);
    arr.add(30);
    arr.add(10);
    arr.add(50);
    arr.add(20);

    // Create a list of items by filtering
    List<Integer> arr2 = arr.stream().sorted().toList();

    for (Integer integer : arr2) {
      System.out.println(integer);
    }
  }
}

```

### Java Database Connectivity

<!-- TODO : TBD -->