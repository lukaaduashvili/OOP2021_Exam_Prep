package Sem14;

import java.util.Calendar;
import java.util.GregorianCalendar;

class Worker implements Runnable {
    private Main m;

    public Worker(Main m) {
        this.m = m;
    }

    @Override
    public void run() {
        m.doWork();
    }
}


public class Main implements Runnable{
    @Override
    public void run() {

    }

    private String name;
    public Main(String name) {
        this.name = name;
    }

    public void doWork() {
        synchronized (this) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start =  System.nanoTime();
        int n = 1000;
        Thread[] t = new Thread[n];
        Main[] m = new Main[n];
        for(int i = 0; i < n; i++) {
            m[i] = new Main(i +" thread");
            t[i] = new Thread(new Worker(m[i]));
            t[i].start();
        }

        for(int i = 0; i < n; i++) {
            t[i].join();
        }
        long end =  System.nanoTime();
        System.out.println(end-start);
    }
}
