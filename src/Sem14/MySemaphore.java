package Sem14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySemaphore {
    private Lock lock;
    private Condition c;
    private int value;

    public MySemaphore(int initial_value) {
        value = initial_value;
        lock = new ReentrantLock();
        c = lock.newCondition();
    }

    public void release(int k) throws InterruptedException {
        lock.lock();
        value+=k;
        c.signalAll();
        lock.unlock();

    }

    public void release() throws InterruptedException {release(1);}

    public void acquire(int k) throws InterruptedException {
        lock.lock();
        while(value < k)
            c.await();
        value -= k;
        lock.unlock();
    }

    public void acquire() throws InterruptedException {acquire(1);}
}
