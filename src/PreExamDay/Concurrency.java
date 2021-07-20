package PreExamDay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {
    int[] trees;
    mySemaphore ended;
    Lock upDate;
    int tree;
    Condition checkCond;
    int iter;
    int treeTh;
    mySemaphore updated;

    public Worker(int[] trees, mySemaphore ended, Lock upDate, int tree, Condition checkCond, mySemaphore updated) {
        this.ended = ended;
        this.upDate = upDate;
        this.trees = trees;
        this.tree = tree;
        this.checkCond = checkCond;
        this.updated = updated;
        iter = 0;
        treeTh = 0;
    }

    @Override
    public void run() {
        while(true) {
            // tree = asdasdfafasfad;
            upDate.lock();
            treeTh++;
            if(treeTh == trees.length) {
                checkCond.notify();
                try {
                    updated.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                treeTh = 0;
            }
            upDate.unlock();
        }
    }
}

class checker implements Runnable {
    int[] trees;
    Condition checkCond;
    mySemaphore updated;
    mySemaphore end;
    int iter;
    public checker(int[] trees, Condition checkCond, mySemaphore updated, mySemaphore end) {
        this.trees = trees;
        this.checkCond = checkCond;
        this.end = end;
        this.updated = updated;
        iter = 0;
    }

    @Override
    public void run() {
        while(true) {
            try {
                checkCond.await();
                iter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //see if array gamodis
            //if gamodis
                //print iter
                end.release();
                break;
            //else
                //updated.release(trees.length);
                //
        }
    }
}

class mySemaphore {
    private int num;
    private Lock lock;
    private Condition cond;

    public mySemaphore(int num) {
        this.num = num;
        this.lock = new ReentrantLock();
        this.cond = lock.newCondition();
    }

    public void await() throws InterruptedException {
        await(1);
    }

    public void await(int k) throws InterruptedException {
        lock.lock();
        while(num < k) {
            cond.await();
        }
        num-=1;
        lock.unlock();
    }

    public void release() {
        release(1);
    }

    public void release(int k) {
        lock.lock();
        num+=1;
        cond.notifyAll();
        lock.unlock();
    }

}


public class Concurrency {
    public static void main(String[] args) throws InterruptedException {
        int[] trees = new int[]{2, 1, 3, 4};
        mySemaphore ended = new mySemaphore(trees.length);
        Lock update = new ReentrantLock();
        Condition newCond = update.newCondition();
        mySemaphore endProccess = new mySemaphore(0);
        mySemaphore updated = new mySemaphore(0);

        for(int i = 0; i < trees.length; i++) {
            Thread myThread = new Thread(new Worker(trees, ended, update, trees[i], newCond, updated));
            myThread.start();
        }
        Thread checker = new Thread(new checker(trees, newCond, updated, endProccess));
        endProccess.await();
    }
}
