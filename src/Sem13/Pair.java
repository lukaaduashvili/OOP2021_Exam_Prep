package Sem13;



public class Pair {
    //private Lock lock;
    private int a;
    private int b;

    public Pair() {
        a = 0;
        b = 0;
        //lock = new ReentrantLock();
    }

    public synchronized void inc() {
        //lock.lock();
        //synchronized (this) {
            a++;
            b++;
        //}
        //lock.unlock();
    }

    public synchronized int sum() {
        //lock.lock();
        int tmp;
        //synchronized (this) {
            tmp = a + b;
        //}
        //lock.unlock();
        return tmp;
    }
}
