package Sem15;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayListBlockingQueue<Integer> q = new ArrayListBlockingQueue(5);
        Thread t = new Thread(() -> {
            int e = q.pop();
            System.out.println("1 Popped: " + e);
        });
        Thread z = new Thread(() -> {
            int e = q.pop();
            System.out.println("2 Popped: " + e);
        });
        Thread t1 = new Thread(() -> {
            q.push(1);
            q.push(2);
        });
        t.start();
        z.start();
        Thread.sleep(10);
        t1.start();
        z.join();
        t.join();
        t1.join();
    }
}
