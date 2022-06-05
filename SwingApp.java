import java.awt.event.*;
import javax.swing.*;

public class SwingApp extends JFrame {
  JLabel label = new JLabel("Hello World");
  JButton btn1 = new JButton("Alpha"); 
  JButton btn2 = new JButton("Beta");

  SwingApp() {
    // Initialize the app with the following properties
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLayout(null);
    
    // Set the positioning of the components
    label.setBounds(20, 20, 150, 30);
    btn1.setBounds(20, 60, 100, 30);
    btn2.setBounds(150, 60, 100, 30);

    // Add the components to the canvas
    add(label);
    add(btn1);
    add(btn2);

    // Add event listeners to the buttons
    btn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        label.setText("Alpha Pressed");
      }
    });
    btn2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        label.setText("Beta Pressed");
      }
    });
  }

  public static void main(String[] args) {
    new SwingApp();
  }
}
