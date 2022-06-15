import java.awt.*;
import java.awt.event.*;

public class FrameEx extends Frame {
  // Declare the UI Components
  Label text = new Label("Hello, World!");

  // Create the constructor
  FrameEx() {
    this.setTitle("Hello World App"); // This is the window title
    this.show(); // This shows the window on the screen
    this.setLayout(null); // This removes the preapplied layout
    this.setSize(500, 300); // This sets the size of the window.

    // Handle the closing of the window
    this.addWindowListener(new WindowAdapter() { // Window Adapter Constructor
      public void windowClosing(WindowEvent e) { // Define the window Closing action
        dispose(); // Dispose the resources and close the app
      }
    });
  
    // Add the UI to the frame
    add(text).setBounds(20, 20, 200, 34);
  }
  
  // Start the application
  public static void main(String[] args) {
    new FrameEx(); // Start a new nstance of the app.
  }

}