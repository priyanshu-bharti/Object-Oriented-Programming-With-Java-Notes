import java.awt.event.*;
import javax.swing.*;

public class SwingEx extends JFrame {
  // Add UI
  JLabel l = new JLabel("Hello Moto!");

  // Constructor
  SwingEx() {
    setTitle("Basic Program");
    setSize(500, 300);
    setLayout(null);
    show();

    // Window closing
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add the UI to frame
    add(l).setBounds(20, 20, 200, 34);
  }

  // Main
  public static void main(String[] args) {
    new SwingEx();
  }
}
