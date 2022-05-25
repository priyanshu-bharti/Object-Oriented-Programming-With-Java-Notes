class Display {
  public void display() {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
  }
}

class ClassThread extends Thread {
  String threadname;
  Display disp = new Display();

  ClassThread(String threadname) {
    this.threadname = threadname;
  }
  
  @Override
  public void run() {
    System.out.println("Starting Thread " + threadname);
    // creating a sync block and passing reference to an object to it.
    // Passing reference would allow synchronized to access the implicit monitor.
    synchronized(disp) {
      disp.display();
    }
    System.out.println("\n");
  }
}

// Calling the threads.
public class ThreadClass {
  public static void main(String[] args) {
    ClassThread t1 = new ClassThread("1");
    ClassThread t2 = new ClassThread("2");
    t1.start();
    t2.start();
  }
}
