class SharedResource {
  int data;

  // True - Producer gets the resource 
  // False - Consumer gets the resource
  boolean flag = true;

  // Write the data into the buffer
  public synchronized void set(int value) {
    // While the consumer is accessing the resource
    while (!flag) {
      // Wait indefinitely till the resource is freed.
      try { wait(); } catch (Exception e) {}
    }

    // save the data
    this.data = value;
  }

  // Get the data from the buffer
  public synchronized int get() {
    // While consumer is accessing the resource.
    while (flag) {
      // Wait indefinitely till the resource is freed
      try { wait(); } catch (Exception e) {}
    }

    // Give the flag to Producer.
    flag = true;
    notify();

    // Get the data
    return this.data;
  }
}

// Producer code
class Producer extends Thread {
  SharedResource res;
  Producer(SharedResource res) {
    this.res = res;
  }
  @Override
  public void run() {
    int count = 1;
    while(true) {
      System.out.println(count);
      res.set(count++);
    }
  }
}

// Consumer code
class Consumer extends Thread {
  SharedResource res;
  Consumer(SharedResource res) {
    this.res = res;
  }
  @Override
  public void run() {
    while(true) {
      System.out.println(res.get());
    }
  }
}

// Driver Code
public class ThreadInterface {
  public static void main(String[] args) {
    SharedResource r = new SharedResource();
    Producer prod = new Producer(r);
    Consumer cons = new Consumer(r);

    prod.start();
    cons.start();
  }
}