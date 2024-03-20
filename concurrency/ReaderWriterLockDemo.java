import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
      ReadWriteLock rwLock = new ReentrantReadWriteLock();
      SharedObject s = new SharedObject();

      Thread w1 = new Thread(new Writer(s, rwLock));
      Thread w2 = new Thread(new Writer(s, rwLock));

      w1.start();
      w2.start();

      w1.join();
      w2.join();
      
      // Without the lock, the values will not be guarateed to be 2000
      System.out.println("Final counter value: " + s.i);
    }
}

class SharedObject {
  int i;

  SharedObject() {
    this.i = 0;
  }

  void incrementCounter() {
      // Simulate some processing time
      try {
          Thread.sleep(1);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      // Increment the counter
      i++;
  }
}


class Writer implements Runnable {

  SharedObject s;
  ReadWriteLock rwLock;

  Writer(SharedObject s, ReadWriteLock rwLock) {
    this.s = s;
    this.rwLock = rwLock;
  }

	@Override
	public void run() {
    for (int i = 0; i < 1000; i++) {
      try {
        rwLock.writeLock().lock();;
        s.incrementCounter();
      } finally {
        rwLock.writeLock().unlock();
      }
    }
	}
}
