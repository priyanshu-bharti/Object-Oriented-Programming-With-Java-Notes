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
