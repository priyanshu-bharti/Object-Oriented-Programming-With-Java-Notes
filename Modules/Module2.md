# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 2 : More Object Oriented Programming

- [x] ~~Inheritance~~
- [x] ~~Types of inheritance~~
- [x] ~~Method Overriding~~ (Module 1)
- [x] ~~Dynamic Method Dispatch~~ (Module 1)
- [x] ~~Abstract Classes~~ (Module 1)
- [x] ~~Interfaces~~ (Module 1)
- [x] ~~Creating and Using Packages~~
- [x] ~~Importing Packages~~
- [x] ~~Access Specifiers~~ (Module 1)

## Inheritance

- Allows a child class to inherit the properties defined in the parent class such as data members and methods.
- Represents **IS-A** relationship
- Used using `extends` keyword.
- Promotes code re-use and readability
- The class that defines the behavior for the child class is called the parent class super class or base class.
- The class that gets the members and methods using inheritance is called child class, derived class or the subclass.

## Types of Inheritances

### Single Level Inheritance

- Single parent has a single child.
- Child gets all the properties of the parent.

```java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class TestInheritance {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.bark();
        d.eat();
    }
}
```

### Multi-level Inheritance

- Extension of the single inheritance
- Parent has a child which in turn has another child

```java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class BabyDog extends Dog {
    void weep() {
        System.out.println("weeping...");
    }
}

class TestInheritance2 {
    public static void main(String args[]) {
        BabyDog d = new BabyDog();
        d.weep();
        d.bark();
        d.eat();
    }
}
```

### Hierarchical Inheritance

- One parent can have multiple children
- Children then can have multiple child classes
- Forms a tree like hierarchical structure.

```java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("meowing...");
    }
}

class TestInheritance3 {
    public static void main(String args[]) {
        Cat c = new Cat();
        c.meow();
        c.eat();
        //c.bark();
        //C.T.Error
    }
}
```

### Hybrid Inheritance

- Combinations of different kinds of inheritances discussed above

### Multiple Inheritance (uses interfaces)

- Child has multiple parents
- Defined using interfaces
- May cause ambiguity if both parents have some property in common.

```java
interface AnimalEat {
    void eat();
}

interface AnimalTravel {
    void travel();
}

class Animal implements AnimalEat, AnimalTravel {
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void travel() {
        System.out.println("Animal is travelling");
    }
}

public class Demo {
    public static void main(String args[]) {
        Animal a = new Animal();
        a.eat();
        a.travel();
    }
}
```

### Cyclic Inheritance (Not Possible in Java)

- It is a class inheriting itself
- Not possible in java
- Introduces ambiguity

## Packages

- Packages is a collection of classes, sub-packages, and interfaces.
- It helps organize your classes into a folder structure and make it easy to locate and use them.
- More importantly, it helps improve code reusability.
- Each package in Java has its unique name and organizes its classes and interfaces into a separate namespace, or name group.
- Although interfaces and classes with the same name cannot appear in the same package, they can appear in different packages.
- This is possible by assigning a separate namespace to each Java package.

### Creating a package

- To create a package include this at the top of the file which you want to make a package of:

```java
package nameOfPackage;

// Contents...
```

- Then compile the package

```
javac –d . nameOfPackage.java
```

- Importing and Using a Package

```java
import nameOfPackage.*; // Import Everything
import nameOfPackage.NameOfClass; // Specific
```
