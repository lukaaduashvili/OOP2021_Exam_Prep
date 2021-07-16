package Sem13;

class Worker extends Thread {
    private Pair pair;
    public Worker(Pair p) {
        this.pair = p;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            pair.inc();
        }
    }
}

class MyWorker implements Runnable {
    private Pair pair;
    public MyWorker(Pair p) {
        this.pair = p;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            pair.inc();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Pair p = new Pair();
        new MyWorker(p).run();

        Worker x = new Worker(p);
        Thread y = new Thread(new MyWorker(p));

        x.start();
        y.start();

        try {
            x.join();
            y.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(p.sum());
    }
}
