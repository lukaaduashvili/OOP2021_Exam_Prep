package Sem15;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayListBlockingQueue<T> {
    private ArrayList<T> elems;
    private int capacity;
    private Lock lock;
    private Condition insert;
    private Condition remove;

    public ArrayListBlockingQueue(int capacity) {
        this.elems = new ArrayList<>();
        this.capacity = capacity;
        lock = new ReentrantLock();
        insert = lock.newCondition();
        remove = lock.newCondition();
    }

    public void push(T elem) {
        lock.lock();
        while(elems.size() == capacity) {
            try {
                remove.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        elems.add(elem);
        insert.signal();
        lock.unlock();
    }

    public boolean tryPush(T elem, long millis) {
        lock.lock();
        while(elems.size() == capacity && millis > 0) {
            try {
                millis = remove.awaitNanos(1000000*millis)/1000000;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(millis != 0) {
            elems.add(elem);
            insert.signal();
            lock.unlock();
            return  true;
        } else {
            lock.unlock();
            return false;
        }
    }

    public T pop() {
        lock.lock();
        while(elems.size() == 0) {
            try {
                insert.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T ret = elems.remove(0);
        remove.signal();
        lock.unlock();
        return ret;
    }

    public T tryPop(long millis) {
        lock.lock();
        while(elems.size() == 0) {
            try {
                insert.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T ret = elems.remove(0);
        remove.signal();
        lock.unlock();
        return ret;
    }

}
