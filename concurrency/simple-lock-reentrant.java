

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    public static void main(String[] args) {
        // Create a ReentrantLock
        Lock lock = new ReentrantLock();

        // Create and start two threads
        Thread thread1 = new Thread(new Worker(lock), "Thread 1");
        Thread thread2 = new Thread(new Worker(lock), "Thread 2");
        thread1.start();
        thread2.start();
    }

    static class Worker implements Runnable {
        private Lock lock;

        public Worker(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            // Acquire the lock
            System.out.println(Thread.currentThread().getName() + " is waiting for the lock.");
            System.out.flush();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " acquired the lock");

            try {
                // Critical section - protected by the lock
                Thread.sleep(5000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Release the lock
                System.out.print(Thread.currentThread().getName() + " is releasing the lock....");
                System.out.flush();
                lock.unlock();
                System.out.print(Thread.currentThread().getName() + " done");
            }
        }
    }
}
