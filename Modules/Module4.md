# Object Oriented Programming With Java (ITA5004) - Notes

## Module - 4

- [ ] Applet Programming
- [ ] AWT Programming
- [ ] Event handling
- [ ] Swing Components

## Applet Programming

### What is an Applet?

- Applets are small applications that can be viewed on a browser.
- They were transported through the internet and were installed and run as part of web application.
- After the applet is sent to the client, it has limited access to resources.
- This constraint allows data integrity, performance and virus free environment.
- They're not standalone applications, they are just web applications on a browser.

### What are the types of Applets?

1. **AWT Applets**:

- Uses Abstract Window Toolkit for GUI.
- Became available with the early release of Java.

2. **Swing Applets**:

- Based on class `JApplet` which inherits `Applet`
- Uses Swing Component for GUI
- All applet features also work with `JApplet`

### Basic Structure of Applet Programs

```java
// Import the AWT Component library for showing buttons, texts, inputs, etc.
import java.awt.*;
// This contains the Applet class itself.
import java.applet.*;

// Our Custom applet must extend the class Applet.
public class MyApplet extends Applet {
  // This method is used for rendering things on the display.
  public void paint(Graphics g) {
    // Draws "Hello, World!" on the screen 20px from left and 20px from top.
    g.drawString("Hello, World!",20, 20);
  }
}
```

### `paint()`

- Called each time Applet needs to rerender the components.
- This rerender can happen when
  - Components gets overwritten by another application,
  - Mininizing and Maximizing the Window.
- Paint takes a Graphics object as parameter.
- This parameter contains context information of the graphical environment.
- This context is used whenever something has to be rendered on the screen.

### `drawString()`

- `drawString()` is a member of the `Graphics` class.
- This method outputs a string beginning at the specified X,Y Coordinates.

## Applet Program Architecture

- Applet doesn't have `main()` method instead it contains `paint()` method.
- Execution begin when the name of the calss is passed to the Applet tag in the HTML file.
- To create an applet include the following tags in the HTML file or simply place it in the java file after import statements as comments using `/* ... */`.
  ```html
  <applet code="AppletClassName" width="300" height="300"></applet>
  ```
- To compile the applet simply use `javac FileName.java` as you normally would.
- After compilation, run the applet in a old browser that supports it or use the `appletviewer fileName.html` command _(you'll need to revert back to JDK 8 to use it)_.

  ```java
  import java.awt.*;
  import java.applet.*;

  /* <applet code="MyApplet" width=300 height= 300></applet> */

  public class MyApplet extends Applet {
    public void paint(Graphics g) {
      g.drawString("Hello, World!",20, 20);
    }
  }
  ```

### `init()`

- This is the first method that is called
- Variables should be initialized here.
- This method is called only once during the execution.

### `start()`

- Called after `init()`
- Also called to restart the applet after it has stopped.
- Called each time applet is displayed.

### `paint()`

- Called each time when AWT components have to be redrawn on the screen.

### `stop()`

- This is called when the browser leaves the HTML document containing the applet or when it goes to another page.
- When stop is called, applet is still running.
- `stop()` should be used when the threads needs to be suspended.
- It is restarted using `start()` when user returns to the page.

### `destroy()`

- It is called when the environment determines that you have left the application and the memory needs to be released.
- `stop()` is called before `destroy()`.

### Request Painting using `repaint()`

- The applet writes to its window only when the `paint()` is called.
- Whenever the information changes, it implicitly called the `repaint()` method.
- `repaint()` is defined by the AWT library, which in turn calls the `update()` method which then calls `paint()` again.
- `repaint()` has following invocations:
  ```java
  void repaint() // Repaint the window
  void repaint(int x, int y, int width, int height) // Specifies region of repainting
  void repaint(long maxDelay) // Max number of milliseconds before update() is called
  void repaint(long maxDelay, int x, int y, int width, int height) // Combination of above
  ```

### Simple Banner Applet using `repaint()`

Steps for recreating this program are:

**1. Create the MyApplet Class**

1. Import the classes
2. Create a string
3. Create a boolean flag called isThreadStopped
4. Create a thread reference

**2. Implement the init method**

1. Set the background color
2. Set the foreground color

**3. Implement the start method**

1. Set the reference of the current thread to object's thread reference.
2. Set the isThreadStopped to be false
3. Call the `start()` method on the thread reference

**4. Override the run method**

1. Open an infinite loop
   1. Try to:
      1. repaint the screen
      2. After Repaint sleep the thread for some milliseconds of time.
      3. If the thread is sleeping, get out of the loop
   2. Catch any exception that might have happened

**5. Override the stop method**

1. Set the isThreadStopped flag to true
2. Clear the reference of the current thread as null

**6. Implement the paint method**

1. Get the first character of the string
2. Remove the first character from the string
3. Append the character at the end of the string.

**Example of the code is shown below :**

```java
import java.awt.*;
import java.applet.*;

/* <applet code="MyApplet" width=300 height= 300></applet> */

// To repaint something, we need to suspend the thread
// This feature is provided to us by multithreading
public class MyApplet extends Applet implements Runnable {

  // This is a test message
  // This would have width = max-width it can occupy
  String msg = "This is just a test message! ";
  // Create a thread reference to be used later.
  Thread t;

  // Whether the thread is stopped or not.
  boolean isThreadStopped;

  // Define the init function
  // This would be called only once.
  public void init() {
    // We're just setting the background and the foreground color
    setBackground(Color.WHITE);
    setForeground(Color.MAGENTA);
  }

  // Start the thread
  public void start() {
    // Pass the reference of the current thread to the object.
    this.t = new Thread(this);
    // Flag to indicate that the thread is running
    isThreadStopped = false;
    // Start the thread after setting its state above
    t.start();
  }

  // Display Banner
  // The applet starts executing here
  @Override
  public void run() {
    // Infinite loop
    while (true) {
      try {
        // Try to repaint
        repaint();
        // After each repaint, sleep for 0.3 secs
        Thread.sleep(300);
        // Check if the current thread is stopped,
        // If it is, then close the loop
        if (this.isThreadStopped) {
          break;
        }
      }
      // Catch some exception that might be thrown in repaint fails
      catch (Exception e) {}
    }
  }

  // Pause the banner
  @Override
  public void stop() {
    // Firstly, set the flag to be true.
    this.isThreadStopped = true;
    // Clear the reference to the thread reference.
    this.t = null;
  }

  // Use the paint method
  @Override
  public void paint(Graphics g) {
    // Get the first character
    char ch = this.msg.charAt(0);
    // Get entire string except the first character
    msg = msg.substring(1, this.msg.length());
    // Append the character to the end of the remaining string.
    msg += ch;
    // Print the string
    g.drawString(this.msg, 20, 20);
  }
}
```

### Showing statusbar using `showStatus()`

- We can use the in-built showStatus method in java to create a statusbar

  ```java
  import java.awt.*;
  import java.applet.*;

  /*<applet code="MyApplet" width=200 height=200></applet>*/

  public class MyApplet extends Applet{
    @Override
    public void paint(Graphics g) {
      g.drawString("Hey ya!", 20, 20);
      // This would print a statusbar on the bottom of the applet window
      showStatus(" This is a custom status");
    }
  }
  ```

### Passing Parameters to Applet.

```java

```

### Changing Text Based on Button Press

When working with button remember to use **`ActionListener`** Interface

```java
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
```

### Changing String Labels according to the Checkbox

When working with a checkbox group, make sure to use **`ItemListener`** Interface.

```java
// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=300 height=200></applet>*/

// Make sure to implement ItemListener
public class MyApplet extends Applet implements ItemListener {
  // Message to Print
  String message = "";
  // Declare checkboxes
  Checkbox windows11, archLinux, macOS, freeBSD;
  CheckboxGroup checkboxGroup;

  public void init() {
    // Instantiate a new checkbox group
    this.checkboxGroup = new CheckboxGroup();

    // Create checkbox objects
    macOS = new Checkbox("macOS 12 Monterey", checkboxGroup, true);
    archLinux = new Checkbox("Arch Linux", checkboxGroup, false);
    windows11 = new Checkbox("Windows 11", checkboxGroup, false);
    freeBSD = new Checkbox("Free BSD", checkboxGroup, false);

    // Add the checkboxes to the window
    add(macOS);
    add(archLinux);
    add(windows11);
    add(freeBSD);

    // Add action listener to the buttons
    macOS.addItemListener(this);
    archLinux.addItemListener(this);
    windows11.addItemListener(this);
    freeBSD.addItemListener(this);
  }

  // repaint the screen when checkbox state changes
  public void itemStateChanged(ItemEvent evt) {
    repaint();
  }

  // Draw the string on repaint
  public void paint(Graphics g) {
    this.message = "Current Selection : " + this.checkboxGroup.getSelectedCheckbox().getLabel();
    g.drawString(message, 20, 100);
  }
}
```

### Printing Checkbox State without using a Checkbox Group

```java
// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=300 height=200></applet>*/

// Make sure to implement ItemListener
public class MyApplet extends Applet implements ItemListener {
  // Message to Print
  String message = "";
  // Declare checkboxes
  Checkbox windows11, archLinux, macOS, freeBSD;

  public void init() {
    // Create checkbox objects
    macOS = new Checkbox("macOS 12 Monterey", null, true);
    archLinux = new Checkbox("Arch Linux", null, false);
    windows11 = new Checkbox("Windows 11", null, false);
    freeBSD = new Checkbox("Free BSD", null, false);

    // Add the checkboxes to the window
    add(macOS);
    add(archLinux);
    add(windows11);
    add(freeBSD);

    // Add action listener to the buttons
    macOS.addItemListener(this);
    archLinux.addItemListener(this);
    windows11.addItemListener(this);
    freeBSD.addItemListener(this);
  }

  // repaint the screen when checkbox state changes
  public void itemStateChanged(ItemEvent evt) {
    repaint();
  }

  // Draw the string on repaint
  public void paint(Graphics g) {
    this.message = "Your OS of Choice : ";
    g.drawString(message, 20, 100);
    this.message = "macOS 12 Monterey : " + macOS.getState();
    g.drawString(message, 20, 120);
    this.message = "Arch Linux : " + archLinux.getState();
    g.drawString(message, 20, 140);
    this.message = "Windows 11 : " + windows11.getState();
    g.drawString(message, 20, 160);
    this.message = "FreeBSD : " + freeBSD.getState();
    g.drawString(message, 20, 180);
  }
}
```

### Creating Dropdowns with Choices and Changing the String

```java
// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=300 height=200></applet>*/

// Make sure to implement ItemListener
public class MyApplet extends Applet implements ItemListener {
  // Message to Print
  String message = "";
  // Choices
  Choice os, browser;

  public void init() {
    os = new Choice();
    browser = new Choice();

    // Add items to OS Choice list
    os.add("macOS 12");
    os.add("Windows 11");
    os.add("Arch Linux");
    os.add("FreeBSD");

    // Add items to Browser Choice list
    browser.add("Firefox");
    browser.add("Chrome");
    browser.add("Edge");
    browser.add("Safari");

    // Add both the lists to the window
    add(os);
    add(browser);

    os.addItemListener(this);
    browser.addItemListener(this);
  }

  // repaint the screen when checkbox state changes
  public void itemStateChanged(ItemEvent evt) {
    repaint();
  }

  // Draw the string on repaint
  public void paint(Graphics g) {
    this.message = "Current OS : " + os.getSelectedItem();
    g.drawString(this.message, 20, 100);
    this.message = "Current Browser : " + browser.getSelectedItem();
    g.drawString(this.message, 20, 120);
  }
}
```

### Using labels

```java
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=300 height=200></applet>*/

// Make sure to implement ItemListener
public class MyApplet extends Applet {
  public void init() {
    Label one = new Label("One");
    Label two = new Label("Two");
    Label three = new Label("Three");

    add(one);
    add(two);
    add(three);
  }

}
```

### Mouse Press Events

```java
// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=300 height=200></applet>*/

// Make sure to implement ItemListener
public class MyApplet extends Applet implements MouseListener, MouseMotionListener {
  String message = "";

  public void init() {
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void mouseClicked(MouseEvent evt) {
    this.message = "Mouse Clicked";
    repaint();
  }
  public void mouseEntered(MouseEvent evt) {
    this.message = "Mouse Entered";
    repaint();
  }
  public void mouseExited(MouseEvent evt) {
    this.message = "Mouse Exited";
    repaint();
  }
  public void mousePressed(MouseEvent evt) {
    this.message = "Mouse Pressed Down";
    repaint();
  }
  public void mouseReleased(MouseEvent evt) {
    this.message = "Mouse Button Released";
    repaint();
  }
  public void mouseDragged(MouseEvent evt) {
    this.message = "Mouse is being dragged";
    showStatus("Dragging X: " + evt.getX() + " Y: " + evt.getY());
    repaint();
  }
  public void mouseMoved(MouseEvent evt) {
    this.message = "Mouse is being moved";
    showStatus("Moving X: " + evt.getX() + " Y: " + evt.getY());
    repaint();
  }
  public void paint(Graphics g) {
    g.drawString(this.message, 20, 20);
  }
}
```

### Key Press Events

```java
// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=300 height=200></applet>*/

// Make sure to implement ItemListener
public class MyApplet extends Applet implements KeyListener {
  String message = "";

  public void init() {
    addKeyListener(this);
    requestFocus();
  }

  public void keyPressed(KeyEvent evt) {
    showStatus("Key Pressed Down");
  }

  public void keyReleased(KeyEvent evt) {
    showStatus("Key Released");
  }

  public void keyTyped(KeyEvent evt) {
    this.message = evt.getKeyChar() +  " Key Pressed";
    repaint();
  }

  public void paint(Graphics g) {
    g.drawString(this.message, 20, 20);
  }

}
```

### Text inputs

```java
// Import this to perform event handling
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width=400 height=200></applet>*/

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
```

## AWT Programming

## Swing Components
