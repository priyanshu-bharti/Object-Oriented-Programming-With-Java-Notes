# Object Oriented Programming With Java (ITA5004) - Notes
# Module - 1 : Introduction to Object Oriented Programming
- [x] ~~Classes and Objects~~
- [x] ~~Overloading Methods~~
- [x] ~~Passing and Receiving Objects~~
- [x] ~~Controlling access to member functions and methods~~
- [x] ~~Static and Final Keywords~~
- [x] ~~String handling~~

## Interfaces
* Mechanism to achieve abstraction
* Contains **only abstract methods not their body**
* Used to achieve abstraction and multiple inheritance
* A class implementing interface must also implement **all of its methods**.
* Similar to abstract classes, **you can’t create objects using interfaces**.
* Body of the interface’s methods must be provided in the implements class.
* **Interface methods are by default abstract and public**
* It can also be used to **achieve loose coupling**

### There can be following relationships between the classes and the interfaces
1. Classes  -> Extends -> Class
2. Interface  -> Extends -> Interface
3. Class -> Implements -> Interface.

### Example of Class implementing an interface
```java
interface Animal {
    // Interface method declaration without body

    public void sound();

    public void run();
}

public class Main implements Animal {

    public static void main(String[] args) {
        sound();
        run();
    }

    @Override
    public static void sound() {
        System.out.println("Animal Sound Implementation");
    }

    @Override
    public static void run() {
        System.out.println("Animal Run Implementation");
    }
}

```

### Implementing Multiple Interfaces
```java
interface Animal {
    public void sound();
}

interface Pet {
    public void feed();
}

public class Main implements Animal, Pet {

    public void main(String[] args) {
        sound();
    }

    @Override
    public void sound() {
        System.out.println("Animal Sound Implementation");
    }

    @Override
    public void feed() {
        System.out.println("Feeding the Pet");
    }
}

```

## Abstract Class vs Interfaces
### Abstract Class
* Can have abstract and non-abstract methods
* Doesn’t support multiple inheritance
* Can have final, non-final, and non-static variables.
* Abstract class can provide the implementation for the interface
* Declared using `abstract` keyword.
* Can extend another class and implement multiple interfaces
* Supports access modifiers for methods and variables.

### Interfaces
* Has only abstract methods
* Supports multiple inheritance
* Can have only final, and static variables.
* Interfaces can’t provide the implementation for the Abstract class
* Declared using `Interface` keyword and implemented using `implements` keyword.
* All the methods and members are public by default.

## Access Modifiers
* Specifies the accessibility or scope of a field, method, constructor, or a class.
* They’re of the following types:
	* **Private:** Within Class
	* **Default:** Within Class, and Package
	* **Protected:** Within Class, Package, and Outside Package using Inheritance.
	* **Public:** Within Class, Package, and Outside Package with and without Inheritance.

## `abstract` Keyword
* It can be applied on methods, classes and variables
* Abstract method contains only the methods not the implementation
* Any class that contains more than or equal to 1 abstract methods must be declared `abstract`

```java
abstract class Student {
    abstract void getStudentName();
}

public class Main extends Student {

    @Override
    void getStudentName() {
        System.out.println(“Method Implemented Here”);
    }
}
```

## `this` Keyword
* `this` is a reference variable which refers for the current object.
* `this` is used to invoke the methods or constructors of the current class
* `this` can be passed as an argument in the method or constructor call.
* `this` can resolve the problem of ambiguity.

```java
// A simple this keyword usage
class Student {
    int rollNumber;
    String name;
    Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    void display() {
        System.out.println("Roll Number : " + this.rollNumber);
        System.out.println("Name : " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student(13, "Priyanshu");
        s.display();
    }
}

// Roll Number : 13
// Name : Priyanshu

```

```java
// Another usage where 'this' calls the constructor
class MyClass {
    String property;

    MyClass() {
        System.out.println("Non-Parameterized Constructor");
    }

    MyClass(String property) {
        this(); // Invokes the non-parameterized constructor
        this.property = property;
        System.out.println("Parameterized Constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass m = new MyClass("Some Property");
    }
}

// Non-Parameterized Constructor
// Parameterized Constructor

// If you want to call the parameterized constructor 
// using the 'this' keyword then
// you also need to pass the parameters.
```

## `final` Keyword
* It is used to restrict the user
* Final could be used on:
	* **Variable** - To make a variable constant.
		* You can also have lazy initialization of the final variable inside the constructor only. 
		* Such variables are initially declared using the `final` keyword but are not initialized.
		* After the constructor is called they are initialized and the first value they take is made final.
	* **Method** - To make it non-overridable
	* **Class** - To make it non-extendible

```java
// This is a final class that can't be extended
final class Another {
    Another() {
        System.out.println("This can't be extended");
    }
}

class AnotherClass {
    final void area() {
        System.out.println("This can't be overridden");
    }
}

public class Main extends AnotherClass {
    final int finalVariable = 10; // The value of this variable can't be changed now.
    final int lazyInitialization; // Blank final variable

    Main() {
        this.lazyInitialization = 20; // Lazy initialization.
    }
    // The following code is illegal 
    /*
    void area() {
        System.out.println("This is overridden thing");
    }
    */
    public static void main(String[] args) {
			System.out.println("Main Method");
    }
}

```

## `static` Keyword
* Used for those methods or members that are common between the objects.
* Java allocates memory only once to those properties which are defined using the `static` keyword.

### Static Variables
* They’re like global variables which gets memory once and the value is shared across the instances.

### Static Methods
* Declared using static keyword
* They can only directly call other static methods
* They can only directly access static variables
* They can’t refer to this or super objects.
* The static methods can be called directly using the name of the class.

### Static Blocks
* The blocks that are declared static are called as soon as they’re loaded

### Static Nested Classes
* A static class that is created inside a class is called a static nested class
* It can’t access non-static members and methods
* It can be accessed using the outer class name
* It can access static data members of the outer class including private.
* Static nested class can’t access non-static data members

```java
// This is the outer class
public class Main {
    static int data = 30;

    // Inner class inside outer class
    static class InnnerClass {
        void message() {
            // access only the static variables 
			  // declared in the outer class.
            System.out.println("Data : " + Main.data);
        }
    }

    public static void main(String[] args) {
        // Create objects of the inner class 
		  // using the name of the outer one
        Main.InnnerClass newObj = new Main.InnnerClass();
        // Here the initialization takes place 
		  // as InnerClass is a property of the outer one.
    }
}
```

## Strings
* It is an array of characters
* Strings are immutable
* When the value is changed, a new reference to the value is created and the older one is picked up by the garbage collector.
* Declared using the `string` keyword.
* Strings in java doesn’t require null termination.
* String methods are:
	* **Concatenation** : `+`
	* **Length of the string** :  `str.length()`
	* **Character present at an index position** : `str.charAt(index)`
	* **Extracting a substring** : `str.substring(start, endExclusive)`
	* **First occurrence of a char** : `str.indexOf(character)`
	* **Last occurrence of a char** : `str.lastIndexOf(character)`
	* **Convert String to uppercase** : `str.toUpperCase()`
	* **Convert String to lowercase** : `str.toLowerCase()`
	* **Check if the strings are equal** : `str.equals(String2)`
	* **Replace a character** : `str.replace(oldChar, newChar)`

## Arrays
* Contains multiple homogeneous elements
* You can declare arrays using square brackets representing the subscript
* Example : `int[] marks = new int[3]; `
* If you initialize an array without any value then it would have a value of null (in case of strings), 0 (for integers) or false (if there is an array of boolean)
* To use methods for handling arrays,  `import java.util.Arrays;` 
* We have arrays of multiple dimensions.

## Reserved Words in Java
1. `abstract` : Declare abstract class
2. `boolean` : Type boolean
3. `break` : break out from the loop or switch
4. `byte` : Declare a variable that holds 8 bits
5. `case` : Used with switch for defining a case for switch
6. `catch` : Used to get the exception generated from the try block
7. `char` : Declare the unicode character variable
8. `class` : Declare a class
9. `continue` : skip the current iteration and move to next iteration.
10. `default` : Define the default case for switch statements
11. `do` : Specify what to execute before checking for a `while` condition
12. `double` : 64 bit floating point value
13. `else` : Alternate condition for `if`
14. `enum` : Declare fixed sets of constant values
15. `extends` : Indicate a class is derived from another class
16. `final` : variable that holds a constant value. 
17. `finally` : Indicates a block of code performed after try/catch
18. `float` :  32-bit floating point number
19. `for` : start a loop with initialization, condition and steps
20. `if` : Execute a block of code if criteria is met.
21. `implements` : Implement an interface
22. `import` : import classes or packages
23. `int` : integer type (4-bytes)
24. `interface` : Declare interface
25. `long` : 64-bit long integer
26. `native` : Specify a method is implemented in java code
27. `new` : Created new objects
28. `null` : Indicates references point to nothing.
29. `package` : Declare packages that includes some classes.
30. `private` : Access only within a class
31. `protected` : Access within a class, file, and subclasses.
32. `public` : Access anywhere.
33. `return` : Return a value when the function completes execution.
34. `short` : 16-bit short integer.
35. `static` : Indicate something is allocated memory once and is global
36. `strictfp` : Restrict precision calculation to specified value.
37. `super` : Reference to parent for invoking parent class methods.
38. `switch` : Switch control based on exception test expression.
39. `synchronized` : Specify critical section in multithreading systems.
40. `throw` : Throw exception explicitly
41. `throws` : Declare an exception; Checked Exceptions propations
42. `transient` : the member is not serialized.
43. `try` : Test code for exceptions
44. `void` : Type that returns nothing.
45. `volatile` : Modify variable value by different threads
46. `while` : loop while a condition is true.

## Method overriding
* Child class has methods of same name and type signature
* Child class would then provide a different declaration of the method defined in the parent.
* When child class calls the overridden method its version is called instead of the parent’s one
* This is called **runtime polymorphism** or **dynamic polymorphism** or **Late binding** or **Dynamic Method Dispatch**
* To access the non-overridden method from child use `super` 
* Promotes code reuse and robustness.

### Method Overloading vs Overriding
* **Overloading** - Different method is called based on the type signature.
* **Overriding** - Name and types are same.

### Dynamic Method Dispatch 
* When we create any reference to any object containing overridden method, the call is resolved at runtime not compile-time.
* Suppose there are 3 classes A, B, and C containing the same method `show()`
* Now, consider that A is parent to both B and C
* If we make 3 objects of A, B and C, and create references of type A then `show()` would be called based on the object that invokes it.

```java
class A {
    void m1() {
        System.out.println("Inside A's m1 method");
    }
}
  
class B extends A {
    // overriding m1()
    void m1() {
        System.out.println("Inside B's m1 method");
    }
}
  
class C extends A {
    // overriding m1()
    void m1() {
        System.out.println("Inside C's m1 method");
    }
}
  
class Dispatch {
    public static void main(String args[]) {
        // object of type A
        A a = new A();
        // object of type B
        B b = new B();
        // object of type C
        C c = new C();
        // obtain a reference of type A
        A ref;
        // ref refers to an A object
        ref = a;
        // calling A's version of m1()
        ref.m1();
        // now ref refers to a B object
        ref = b;
        // calling B's version of m1()
        ref.m1();
        // now ref refers to a C object
        ref = c;
        // calling C's version of m1()
        ref.m1();
    }
}
```

---
