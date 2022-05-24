# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 3

- [ ] Exception Handling
- [ ] Built in exceptions
- [ ] User Defined Exceptions
- [ ] Multithreading
- [ ] Thread Creation
- [ ] Sleep
- [ ] Runnable Interface

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

1. **ArithmeticException** :
1. **ArrayIndexOutOfBoundsException** :
1. **StringIndexOutOfBoundsException** :
1. **NumberFormatException** :
1. **NoSuchClassException** :
1. **NoSuchMethodException** :
1. **NoSuchFieldException** :
1. **RuntimeException** :
1. **InterruptedException** :
1. **IOException** :
1. **DivideByZeroException** :

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

### What is a thread

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

[![Thread Lifecycle](http://ebhor.com/wp-content/uploads/2018/11/drawit-diagram-2.png)](http://ebhor.com/wp-content/uploads/2018/11/drawit-diagram-2.png)

### Thread Methods

- **`getID()`** :
- **`getName()`** :
- **`getPriority()`** :
- **`getState()`** :
- **`getThreadGroup()`** :
- **`isInterrupted()`** :
- **`interrupt()`** :
- **`run()`** :
- **`activeCount()`** :
- **`currentThread()`** :
- **`setName(String name)`** :
- **`setPriority(int <1 to 10>)`** :
- **`setDaemon(boolean true or false)`** :
- **`isDaemon()`** :
- **`isAlive()`** :
- **`join()`** :
- **`join(int milliseconds)`** :
- **`start()`** :
- **`yield()`** :
- **`dumpStack()`** :

### Thread Synchronization

- We can prevent multiple threads from accessing a resource using monitors
- Monitors are objects containing data, read(), write(), and queue for resource allocation.
- Queue maintains the track of which thread has requested for the resource.
- Threads can be synchronized using `synchronize` keyword.
- Each object has its own implicit monitor.
