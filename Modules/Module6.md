# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 6 : Collection Framework

- [x] ~~ArrayList~~
- [x] ~~LinkedList~~
- [x] ~~Collection Methods~~
- [x] ~~Comparator~~
- [x] ~~Sets and Hashset~~
- [x] ~~TreeSet~~
- [x] ~~Maps and TreeMaps~~
- [x] ~~HashMaps~~
- [x] ~~Stacks~~
- [x] ~~Queues~~

## Writing the Imports

- In order to use the collections in your program make sure to import the following:

```java
import java.util.*;
```

## ArrayList

- ArrayList is a part of collection framework and is present in java.util package.
- It provides us with dynamic arrays in Java.
- Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.

### ArrayList Declaration

```java
public class App {
  public static void main(String[] args) {
    // Default Constructor
    ArrayList<Integer> arr = new ArrayList<Integer>();
    // Builds from an existing collection c
    ArrayList<Integer> arr = new ArrayList<Integer>(Collection c);
    // Define the initial capacity of the arraylist.
    ArrayList<Integer> arr = new ArrayList<Integer>(int size);


    // Adding or removing things from the list.

    arr.add(index, element); // Add element at a given index
    arr.add(); // Add element at the end
    arr.addAll(Collection c); // Add all elements from the collection c to the arraylist.
    arr.remove(element); // Remove the specified element from the list.
    arr.removeAll(Collection c); // Remove all the elements common to the list and the collection c.
    arr.removeRange(from, to); // Remove elements from (inclusive) - to (exclusive).
    arr.clear(); // Remove all the elements from the list.


    // Return the list or modified list.

    arr.clone(); // Returns a shallow copy of the ArrayList
    arr.toArray(); // Returns the array containing the elements from the list.
    arr.trimToSize(); // Trim the capacity to the number of existing elements.


    // Manipulate list.

    arr.set(index, element); // Replaces the item from the list at index with the new element.


    // Search for some element.

    arr.contains(element); // Returns true if the element is present in the list.
    arr.get(index); // Get any item present at the index.
    arr.indexOf(element); // Get the index of the element.
    arr.lastIndexOf(element); // Get the last index of the element.


    // Getting the size
    arr.size();
  }
}
```

## LinkedList

- Non-contiguous Linear data structure
- Every node is a separate object with data and address to next node.
- The elements are linked using pointers and addresses.
- Each element is known as a node.
- **Advantages** : Dynamicity and ease of insertions and deletions
- **Disadvantages** : Nodes cannot be accessed directly.

```java
public class App {
  public static void main(String[] args) {

    // Constructors
    LinkedList ll = new LinkedList(); // Default Constructor
    LinkedList ll = new LinkedList(Collection c); // Create a LinkedList using another collection.


    // Add something to the list

    ll.add(index, element); // Add an element to the list.
    ll.add(element); // Add an element at the end of the list.
    ll.addAll(index, Collection c); // Add all elements from the collection to the list at index.
    ll.addFirst(element); // Add element at the starting of the list.
    ll.addLast(element); // Add element at the end of the list.
    ll.offer(element); // Adds element as the last element of the list.
    ll.offerFirst(element); // Adds element as the first element of the list.
    ll.offerLast(element); // Adds element as the last element of the list.
    ll.push(element); // Add element through the stack representation of the list.


    // Remove something from the list.

    ll.clear(); // Remove all the elements from the list.
    ll.poll(); // Return and remove the head of the list.
    ll.pollFirst(); // Return and remove the head of the list.
    ll.pollLast(); // Returns and removes the last element of the list.
    ll.pop(); // Removes something through the stack representation of the list.
    ll.remove(); // Removes the head of the list.
    ll.remove(element); // Removes first occurrence of the element from the list.
    ll.remove(index); // Removes element at specified index.
    ll.removeFirst(); // Removes and returns the first element of the list.
    ll.removeFirstOccurrence(element); // Removes the first occurrence of the specified element.
    ll.removeLast(); // Removes and returns the Last element of the list.
    ll.removeLastOccurrence(element); // Removes the Last occurrence of the specified element.


    // Search some element

    ll.element(); // Returns the head of list.
    ll.get(index); // Returns the item at index.
    ll.getFirst(); // Returns the first element.
    ll.getLast(); // Returns the last element.
    ll.contains(element); // Returns true if the element is present in the list.
    ll.indexOf(element); // Returns index of the element.
    ll.lastIndexOf(element); // Returns last index of the element.
    ll.peek(); // Returns the head of the list.
    ll.peekFirst(); // Returns the head of the list or null if list is empty.
    ll.peekLast(); // Returns the tail of the list or null if list is empty.


    // Return the list or some modified version of it

    ll.clone(); // Returns a shallow copy of the list.
    ll.listIterator(index); // Returns a list iterator from the index.
    ll.descendingIterator(); // Returns an iterator in reverse sequential order.


    // Manipulate the list

    ll.set(index, element); // Replaces existing element with the new element.


    // Getting the size of the list.

    ll.size(); // Returns the size of the list
  }
}
```

## Collection Methods

```java
Collections.reverse(arr); // Reverses the collection
Collections.binarySearch(arr, value); // Performs Binary search on the collection
Collections.max(arr); // Searches the max element.
Collections.min(arr); // Searches the min element.
Collections.sort(arr); // Sorts the array in ascending order.
Collections.swap(arr, i, j); // Swaps element at i and j position in arr.
```

## Comparator

- Allows us to define an object that contains a method for comparing 2 values.
- Usually used when called inside the `Collections.sort()` method.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class App {
  public static void main(String[] args) {
    // Initialize the list
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(315);
    arr.add(322);
    arr.add(331);
    arr.add(349);
    arr.add(350);

    // Suppose we want to sort the values based on the digit it ends with.
    arr.sort(new Comparator<Integer>() {
      // This method has to be overridden
      public int compare(Integer a, Integer b) {
        if (a % 10 > b % 10)
          return 1; // If 1 is returned, then the swap happens
        return -1; // if -1 is returned, then nothing happens.
      }
    });

    // Simple Foreach loop to print the values.
    for (Integer integer : arr) {
      System.out.print(integer + " ");
    }
    // Output : 350 331 322 315 349
  }
}

```

## Sets and HashSets

- Interface available in the java.util package.
- An unordered collection or list in with only unique elements.
- The set interface is used to create the mathematical set.
- SortedSet and NavigableSet are two interfaces that extend the set implementation.

### HashSets

- Generic class of the Java collection framework.
- It creates a collection that uses a hash table for storage.
- Using a hashing function to deduce a hash code.
- It is used as the index in which data is stored that is associated with the key.
- Execution time of add, contain, remove, and size operation is constant.
- Very fast operations compared to TreeSet.

```java
import java.util.*;
import java.util.Comparator;
import java.util.Set;

public class App {
  public static void main(String[] args) {
    // Initialize the Set
    Set<Integer> set = new HashSet<Integer>();
    set.add(1);
    set.add(1);
    set.add(1);
    set.add(2);
    set.add(2);
    set.add(2);
    set.add(2);
    set.add(4);
    set.add(4);
    set.add(4);
    set.add(9);
    set.add(9);

    for (Integer integer : set) {
      System.out.print(integer + " ");
    } // 1 2 4 9

    // Common Methods
    set.size(); // Returns the size of the set
    set.contains(element); // Check if an element is present in a set
    set.clear(); // Remove all the element from the set
    set.remove(element); // Remove the element from the set.

  }
}

```

## TreeSets

- It creates a collection that uses a tree for storage.
- TreeSet is a generic class of the Java collection framework.
- It implements the Set interface.
- It uses TreeMap internally to store the TreeSet elements.
- By default, it sorts the elements in natural order (ascending order).
- The order of sorting depends on the Comparator that we have parsed.
- If no Comparator is parsed, it sorts the elements in the natural order.

```java
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Initialize the Set
    Set<Integer> set = new TreeSet();
    set.add(5);
    set.add(1);
    set.add(1);
    set.add(2);
    set.add(8);
    set.add(2);
    set.add(2);
    set.add(4);
    set.add(8);
    set.add(4);
    set.add(9);
    set.add(9);

    for (Integer integer : set) {
      System.out.print(integer + " ");
    } // 1 2 4 9

    // Common Methods
    // set.size(); // Returns the size of the set
    // set.contains(element); // Check if an element is present in a set
    // set.clear(); // Remove all the element from the set
    // set.remove(element); // Remove the element from the set.

  }
}

```

## Maps and TreeMaps

- A map contains values on the basis of key, i.e. key and value pair. 
- Each key and value pair is known as an entry. 
- A Map contains unique keys.
- A Map is useful if you have to search, update or delete elements on the basis of a key.

### TreeMaps

- TreeMap contains values based on the key. 
- TreeMap contains only unique elements.
- TreeMap cannot have a null key but can have multiple null values.
- TreeMap is non synchronized.
- TreeMap maintains ascending order.

```java
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Initialize the Map
    Map<String, String> map = new TreeMap<String, String>();

    map.put("b", "1");
    map.put("d", "2");
    map.put("a", "3");

    for(Map.Entry<String, String> item : map.entrySet()) {
      System.out.println(item.getKey() + " : " + item.getValue());
    }
    // Ouptut:
    // a : 3
    // b : 1
    // d : 2

    // Common Methods
    map.get(key); // Get the value corresponding to the key
    map.size(); // Get the size of the map
    map.clear(); // Remove all elements from the map.
    map.put(new_key, new_value); // Inserts a new_key and its new_value in the map.
    map.containsKey(key); // Check if a key exists in the map.
    map.isEmpty(); // Check if the map is empty
    map.merge(key, value, remappingFunction); // Here the remapping function is used when existing item is found.
  }
}

```

## Hashmaps

- HashMap contains values based on the key.
- HashMap contains only unique keys.
- HashMap may have one null key and multiple null values.
- HashMap is non synchronized.
- HashMap maintains no order.

```java
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Initialize the Map
    Map<String, String> map = new HashMap<String, String>();

    map.put("username", "TripTea_01699");
    map.put("persona", "Astonishingly Ebullient");
    map.put("capability", "Godlike");

    for(Map.Entry<String, String> item : map.entrySet()) {
      System.out.println(item.getKey() + " : " + item.getValue());
    }
    // Output :
    // capability : Godlike
    // persona : Astonishingly Ebullient
    // username : TripTea

    // Common Methods
    map.get(key); // Get the value corresponding to the key
    map.size(); // Get the size of the map
    map.clear(); // Remove all elements from the map.
    map.put(new_key, new_value); // Inserts a new_key and its new_value in the map.
    map.containsKey(key); // Check if a key exists in the map.
    map.isEmpty(); // Check if the map is empty
    map.merge(key, value, remappingFunction); // Here the remapping function is used when existing item is found.

    /*
    map.merge("appearance", "breathtaking", (old_value, new_value) -> old_value + new_value);

    // Explanation:
    // Since there isn't any key called 'appearance', the merge function would simply add a new key with the value.
    // However, if there was indeed a key named 'appearance' and had a value of 'adorable' then the 2 values would've been added together.
    */

  }
}

```

## Stacks

- It is based on **Last-In-First-Out** (LIFO)
- The stack data structure has the two most important operations that are push and pop
- The push operation inserts an element into the stack and pop operation removes an element from the top of the stack

```java
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Initialize the Stack
    Stack<Integer> stack = new Stack<Integer>();

    // Add elements to the stack
    stack.push(1);
    stack.push(6);
    stack.push(13);
    stack.push(11);

    // Get the topmost element
    System.out.println(stack.peek());

    // remove the topmost element from the stack
    System.out.println(stack.pop() + " removed");

    // Check if stack is empty
    stack.empty()

    // Other Methods
    stack.remove(item); // Remove the item from the stack
    stack.add(item); // Add to the end of the interal vector used by stack
    stack.clear(); // Emoty the stack
    stack.get(index); // Get the item at the specified index of the stack
    stack.isEmpty(); // Check if the interal vector of the stack is empty.
    stack.set(index, element); // Change the value of the item at the index.
  }
}

```

## Queues

- Keep the elements that are processed in the First In First Out (FIFO) manner.
- It is an ordered list of objects
- Insertion of elements occurs at the end of the list
- Removal of elements occur at the beginning of the list.

```java
import java.util.*;

public class App {
  public static void main(String[] args) {
    // Initialize the Queue
    Queue<Integer> q = new Queue<Integer>();

    // Methods
    q.add(item); // Add item to the queue's rear end
    q.poll(); // Remove the item at the front
    q.peek(); // Returns the element at front
    q.clear(); // Remove all elements
    q.isEmpty(); // Check if the queue is empty
    q.remove(item); // Remove the item from the queue
    q.size(); // Return the size of the queue
  }
}

```
