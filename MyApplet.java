// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=300 height=200></applet>*/

// Make sure to implement ItemListener
public class MyApplet extends Applet implements ActionListener {
  String message = "";
  Label labelName, labelPass;
  TextField name, pass;

  public void init() {
    this.labelName = new Label("Name : ", Label.RIGHT);
    this.labelPass = new Label("Password : ", Label.RIGHT);

    name = new TextField(10);
    pass = new TextField(10);
    pass.setEchoChar('*');

    add(labelName);
    add(name);
    add(labelPass);
    add(pass);

    name.addActionListener(this);
    pass.addActionListener(this);
  }

  public void actionPerformed(ActionEvent evt) {
    repaint();
  }

  public void paint(Graphics g) {
    g.drawString("Name : " + name.getText(), 20, 100);
    g.drawString("Selected Text in Name : " + name.getSelectedText(), 20, 120);
    g.drawString("Password : " + pass.getText(), 20, 140);
  }
}