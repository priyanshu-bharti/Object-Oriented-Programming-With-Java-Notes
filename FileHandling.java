import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
  public static void main(String[] args) throws IOException {
    // Create a buffered writer to write to the file.
    BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));

    // Write the contents to the file.
    bw.write("Apple\n");
    bw.write("Bethesda\n");
    bw.write("Corsair\n");

    bw.close();

    // Read the contents of the file
    BufferedReader br = new BufferedReader(new FileReader("file.txt"));

    // Output the contents 
    String temp;

    // Print the file's contents
    while ((temp = br.readLine()) != null) {
      System.out.println(temp);
    }

    br.close();
  }
}
