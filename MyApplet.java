
// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=200 height=200></applet>*/

// Make sure to implement ActionListener
public class MyApplet extends Applet implements ActionListener {
  // Message to Print
  String message = "";
  // Declare buttons
  Button yes, no, maybe;

  public void init() {
    // Create buttons
    yes = new Button("Yes");
    no = new Button("No");
    maybe = new Button("Maybe");

    // Add the button to the window
    add(yes);
    add(no);
    add(maybe);

    // Add action listener to the buttons 
    yes.addActionListener(this);
    no.addActionListener(this);
    maybe.addActionListener(this);
  }

  // perform action
  public void actionPerformed(ActionEvent evt) {
    // Get the Button labels
    String str = evt.getActionCommand();

    // Change the message according to the kind of button pressed
    if (str.equals("Yes")) {
      this.message = "You Pressed Yes";
    } else if (str.equals("No")) {
      this.message = "You Pressed No";
    } else {
      this.message = "You Pressed Maybe";
    }

    // Repaint the window
    repaint();
  }

  // Draw the string on repaint
  public void paint(Graphics g) {
    g.drawString(message, 20, 100);
  }
}