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

## Java Database Connectivity

- JDBC is a Java API to connect and execute the query with the database.
- JDBC API uses JDBC drivers to connect with the database.
- We can use JDBC API to access data stored in relational databases.
- JDBC API enables us to insert, and query data from the database.
- It can make use of the 4 possible drivers :
  - **JDBC-ODBC bridge driver**

    - Uses ODBC driver to connect to the database.
    - Converts JDBC method calls into the ODBC function calls.
    - Easy to setup and use.
    - Less Performant

  - **Native-API driver (partially java driver)**

    - Uses the client-side libraries of the database.
    - Converts JDBC method calls into native calls of the database API.
    - It is not written entirely in java.
    - Slightly more performant than JDBC-ODBC Driver.
    - Requires installation on each client system.

  - **Network Protocol driver (fully java driver)** :

    - Uses middleware that converts JDBC calls into vendor-specific database protocol.
    - It is fully written in java.

  - **Thin driver (fully java driver)** :

    - The thin driver converts JDBC calls directly into the vendor-specific database protocol.
    - That is why it is known as thin driver.
    - It is fully written in Java language.

### API

- Stands for Application Programming Interface.
- Usually used to connect two different technologies together using a bridge.
- An API can be created for applications, libraries, operating systems, etc.
- Common applications involving APIs generally separate the frontend from the backend.

### Simple Select Query

```java
import java.sql.*;
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Table Details
    String tableName = "Test";

    // Load the JDBC Driver
    Class.forName("oracle.jdbc.driver.OracleDriver");

    // Create Connection
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");

    // Create Statement Object
    Statement stmt = conn.createStatement();

    // Execute statement
    ResultSet res = stmt.executeQuery("Select * from " + tableName);

    // Get each row until there are no more rows left
    while(res.next()) {
      System.out.println(res.getString(0)); // Gets the first column of the row.
      System.out.println(res.getString(1)); // Gets the second column of the row.
    }

    // Close the connection
    res.close();
    stmt.close();
    conn.close();
  }
}
```

### Simple Insert Query

```java
import java.sql.*;
import java.util.*;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Table Details
    String tableName = "Test";

    // Get the data from the user
    String name = sc.nextLine();
    String age = sc.nextLine();
    String occupation = sc.nextLine();

    // Load the JDBC Driver
    Class.forName("oracle.jdbc.driver.OracleDriver");

    // Create Connection
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");

    // Create Statement Object
    Statement stmt = conn.createStatement();

    // Execute statement
    ResultSet res = stmt.executeQuery("INSERT INTO " + tableName + " (name, age, occupation) VALUES (" + name + "," + age + "," + occupation + ";");

    // Select the inserted data
    ResultSet res = stmt.executeQuery("Select * from " + tableName);

    // Get each row until there are no more rows left
    while(res.next()) {
      System.out.println(res.getString(0)); // Gets the name
      System.out.println(res.getString(1)); // Gets the age
      System.out.println(res.getString(2)); // Gets the occupation
    }

    // Close the connection
    res.close();
    stmt.close();
    conn.close();
  }
}
```
