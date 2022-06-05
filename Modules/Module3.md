# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 3 : Exception Handling and Multithreading

- [x] ~~Exception Handling~~
- [x] ~~Built in exceptions~~
- [x] ~~User Defined Exceptions~~
- [x] ~~Multithreading~~
- [x] ~~Thread Creation~~
- [x] ~~Sleep~~
- [x] ~~Runnable Interface~~

## Exception Handling

- Exceptions are instances when the programs runs into unexpected flow and it crashes.
- Exception handling deals with such situations and makes code reliable and robust.
- The general working of exception handling is as follows:
  1.  Problem Occurs
  1.  Exception is created
  1.  Exception is thrown
  1.  Exception is caught and handled.

### Error vs Exception

| Error                             | Exception                        |
| --------------------------------- | -------------------------------- |
| Impossible to recover             | Possible to handle               |
| Happens at runtime                | Happens at compile and runtime   |
| Unchecked Type                    | Checked and Unchecked            |
| Caused by the runtime environment | Caused by the application itself |

### Throwable Object

- Throwable is the parent to Error and Exception classes.
- Error class has child classes such as:
  - VirtualMachineError
  - StackOverflowError
- Exception class has child classes such as:
  - RuntimeException
  - ArithmeticException
  - NullPointerException

> Exception Object Contains Exception Name and Message

### Unchecked vs Checked Exceptions

| Unchecked Exception           | Checked Exception                                          |
| ----------------------------- | ---------------------------------------------------------- |
| It is ignored by the compiler | Can't be ignored by the compiler, Must be fixed beforehand |
| Happens at runtime            | Happens at compile-time                                    |

### Basic Exception example

```java
// Basic usage of try and catch blocks
class ExceptionExample {
  public static void main(String args[]) {
    try {
      int a = 30; int b = 0;
      a / b;
    } catch (Exception e) {
      System.out.println("Exception");
    }
  }
}
```

### Built-In Exception

1. **ArithmeticException** : Arithmetic error, such as divide-by-zero.
1. **ArrayIndexOutOfBoundsException** : Array index is out-of-bounds.
1. **StringIndexOutOfBoundsException** : Attempt to index outside the bounds of a string.
1. **NumberFormatException** : Invalid conversion of a string to a numeric format.
1. **ClassNotFoundException** : Class not found.
1. **NoSuchMethodException** : A requested method does not exist.
1. **NoSuchFieldException** : A requested field does not exist.
1. **InterruptedException** : A thread has been interrupted
1. **IOException** : I/O Operation has failed.

### User-Defined Exceptions

- Exceptions created by the user
- CustomException class must `extend` Exception class
- You can then override some method e.g. `toString()` to print the exception message.

```java
// Create a new custom exception class
class CustomException extends Exception {
  @override
  public String toString() {
    return "This is a custom exception";
  }
}

// Main Class
public class Main {
  public static void main(String args[]) {
    try {
      throw new CustomException(); // Throws a custom exception
    } catch (CustomException exception) {
      System.out.println(exception.toString()); // Print the message
    }
  }
}

```

### Exception Methods

1. **`try`** : Contains code that may throw an exception
2. **`catch`** : Catches the exception and provides a handling mechanism for the try block
3. **`finally`** : This block always gets executed regardless of whether the exception is thrown or not
4. **`throw`** : Explicitly throws an exception
5. **`throws`** : Give the responsibility of handling the exception to the caller method or the JVM

### Throws Example

```java
public class Main {
  static void myfunc() throws ArithmeticException {
    throw new ArithmeticException("This is an arithmetic exception thrown");
  }

  public static void main(String[] args) {
    try {
      myfunc();
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    }
  }
}
```

### Throw vs Throws

| Throw                                 | Throws                                     |
| ------------------------------------- | ------------------------------------------ |
| Explicitly throw an exception         | Throws - Declares an exception             |
| Checked exception can't be propagated | Checked exceptions can be propagated       |
| Followed by an instance               | Followed by a class                        |
| Can't throw multiple exceptions       | Can declare and throws multiple exceptions |

## What is a thread

- Lightweight subprocess.
- Smallest independent unit of program.
- Each program has at least one thread.
- Thread creation controlled using thread class/runnable interface.
- It is used to run several tasks concurrently.
- Threads share the same address space and are part of the same process
- Low cost of thread switching.

### Why use Multithreading

- Requires less overhead than multitasking processes.
- Interprocess communication is much more costly than interthread communication.
- IPC is costly due to process being in different address space while ITC is inexpensive due to it being within the same address space.

### Thread Lifecycle

- **New** : Create a new thread using `new()` method.
- **Runnable** : Make the thread enter the runnable state using the `start()` method.
- **Running** : Make the execution start using the `run()` method.
- **Waiting** : The thread goes into this state when an interrupt is triggered, or `interrupt()` or `wait()` method is called.
- **Terminated** : When the `run()` method completes its execution.

[![Thread Lifecycle](https://www.scientecheasy.com/wp-content/uploads/2020/06/thread-life-cycle.png)](https://www.scientecheasy.com/wp-content/uploads/2020/06/thread-life-cycle.png)

### Thread creation

- There are 2 ways of creating threads
- Either you can implement a `Runnable` interface or extend the `Thread` class.

### Thread Creation using Runnable Interface

- This is the easiest way to create a thread
- You can construct a thread on any object that implements Runnable interface.
- Steps for creating threads using `Runnable` interface are:

  1. Implement the `Runnable` interface on a class of your choosing
  2. Implement a method called run() in the following manner. Run is just like main method except here the thread execution is limited within the scope of this method.

     ```java
     // Craete a class that implements Runnable
     class InterfaceThread implements Runnable {
       // Override this run method
       @Override
       public void run() {
         // Write whatever you want to do.
         for (int i = 0; i < 10; i++) {
           System.out.println(i + 1);
         }
       }
     }

     // Main Class
     public class Main {
       public static void main(String[] args) {
         // Create runnable object
         Runnable o1 = new InterfaceThread();
         // Create Thread object and pass the runnable object to it.
         Thread t1 = new Thread(o1);
         // Call the start method to start the thread
         t1.start();
       }
     }

     ```

- Steps for creating threads using Thread class are:

  1. Create a class and let it `extend` the class `Thread`
  2. Implement the run method
  3. Create a main class
  4. Create the thread object
  5. Call start() method to start the thread

     ```java
      class ClassThread extends Thread {
        public void run() {
          for (int i = 0; i < 10; i++) {
              System.out.println(i + 1);
          }
        }
      }

      public class ThreadClass {
        public static void main(String[] args) {
          ClassThread t = new ClassThread();
          t.start();
        }
       }
     ```

### Thread Methods

<!-- TODO : COMPLETE THIS PORTION ------------>

- **`start()`** :
- **`sleep()`** :
- **`run()`** :
- **`join()`** :
- **`isAlive()`** :
- **`getName()`** :
- **`getPriority()`** :

### Main Thread

- There is a main thread that runs automatically and executes the program.
- It spawns other child threads.
- Often, it is the last thread to finish the execution.
- It performs various shutdown actions.
- Although it is created automatically, it can be controlled using a Thread object.
- To control the main thread we can use `Thread.currentThread()` which would give us the reference to the current thread which would be main thread.

  ```java
  public class Main {
    public static void main(String args[]) {
      // This is the main thread.
      Thread mainThread = Thread.currentThread();
      // Changing the name of the main thread
      mainThread.setName("Main Thread");

      // Print numbers till 10
      try {
        for (int i = 0; i < 10; i++) {
          System.out.println(i);
          Thread.sleep(100); // Interrupt the main thread.
        }
      } catch (InterruptedException e) {
        // Catch the exception and print the message.
        System.out.println("Main Thread Interrupted");
      }
    }
  }
  ```

### Thread Priorities

- Thread priorities are numbers from 1 to 10 which is used by the scheduler to decide when any thread should be allowed to run.
- To define a priority, use the `setPriority(int priority)` method.

### Thread Synchronization

- We can prevent multiple threads from accessing a resource using monitors
- Monitors are objects containing data, read(), write(), and queue for resource allocation.
- Monitors are mutex locks for any object.
- When thread acquires a lock, it is called entering the monitor.
- Once the lock is acquired and other threads try to gain the lock, they'll be suspended until the first thread exits the monitor.
- Queue maintains the track of which thread has requested for the resource.
- Threads can be synchronized using `synchronize` keyword.
- Each object has its own implicit monitor.

### `synchronized` Keyword

- We can synchronize multiple threads such that they can access the same resource one at a time.
- This synchronization can be done using the `synchronized` keyword
- `synchronized` keyword can be used on a method or can be defined separately.
- For performance reasons, we should prefer synchronized block.

### Example of synchronized method

  ```java
  // Just a class containing the display() method.
  class Display {
    // This is the synchronized method
    // It would be executed by 1 thread at a time.
    public synchronized void display() {
      for (int i = 0; i < 10; i++) {
        System.out.println(i);
      }
    }
  }

  // Just a declaration for the thread.
  class ClassThread extends Thread {
    String threadname;
    Display disp = new Display();

    ClassThread(String threadname) {
      this.threadname = threadname;
    }

    @Override
    public void run() {
      System.out.println("Starting Thread " + threadname);
      disp.display();
      System.out.println("\n");
    }
  }

  // Calling the threads.
  public class ThreadClass {
    public static void main(String[] args) {
      ClassThread t1 = new ClassThread("1");
      ClassThread t2 = new ClassThread("2");
      t1.start();
      t2.start();
    }
  }
  ```

### Example of synchronized block

  ```java
  class Display {
    public void display() {
      for (int i = 0; i < 10; i++) {
        System.out.println(i);
      }
    }
  }

  class ClassThread extends Thread {
    String threadname;
    Display disp = new Display();

    ClassThread(String threadname) {
      this.threadname = threadname;
    }

    @Override
    public void run() {
      System.out.println("Starting Thread " + threadname);
      // creating a sync block and passing reference to an object to it.
      // Passing reference would allow synchronized to access the implicit monitor.
      synchronized(disp) {
        disp.display();
      }
      System.out.println("\n");
    }
  }

  // Calling the threads.
  public class ThreadClass {
    public static void main(String[] args) {
      ClassThread t1 = new ClassThread("1");
      ClassThread t2 = new ClassThread("2");
      t1.start();
      t2.start();
    }
  }
  ```

## Interthread Communication
- Java contains an in-built interprocess communication mechanism
- It provides methods like `wait()`, `notify()`, and `notifyAll()`
- You can communicate data between the synced threads.
- **`wait()` :** halt the execution indefinitely
- **`notify()` :** wake thread up and resume execution

### Producer Consumer Problem

```java

class SharedResource {
  int data;

  // True - Producer gets the resource 
  // False - Consumer gets the resource
  boolean flag = true;

  // Write the data into the buffer
  public synchronized void set(int value) {
    // While the consumer is accessing the resource
    while (!flag) {
      // Wait indefinitely till the resource is freed.
      try { wait(); } catch (Exception e) {}
    }

    // save the data
    this.data = value;
  }

  // Get the data from the buffer
  public synchronized int get() {
    // While consumer is accessing the resource.
    while (flag) {
      // Wait indefinitely till the resource is freed
      try { wait(); } catch (Exception e) {}
    }

    // Give the flag to Producer.
    flag = true;
    notify();

    // Get the data
    return this.data;
  }
}

// Producer code
class Producer extends Thread {
  SharedResource res;
  Producer(SharedResource res) {
    this.res = res;
  }
  @Override
  public void run() {
    int count = 1;
    while(true) {
      System.out.println(count);
      res.set(count++);
    }
  }
}

// Consumer code
class Consumer extends Thread {
  SharedResource res;
  Consumer(SharedResource res) {
    this.res = res;
  }
  @Override
  public void run() {
    while(true) {
      System.out.println(res.get());
    }
  }
}

// Driver Code
public class Main {
  public static void main(String[] args) {
    SharedResource r = new SharedResource();
    Producer prod = new Producer(r);
    Consumer cons = new Consumer(r);

    prod.start();
    cons.start();
  }
}

```
