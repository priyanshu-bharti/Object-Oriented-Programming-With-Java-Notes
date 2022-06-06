# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 6 : Collection Framework

- [x] ~~ArrayList~~
- [x] ~~LinkedList~~
- [x] ~~Collection Methods~~
- [ ] Comparator
- [ ] Sets
- [ ] Hashset
- [ ] Hashmaps

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

-

## Sets

-

## Hashset

-

## Hashmaps

-
