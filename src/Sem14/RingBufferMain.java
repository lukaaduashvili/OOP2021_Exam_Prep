package Sem14;

public class RingBufferMain {
    public static void main(String[] args) throws InterruptedException {
        RingBuffer buffer = new RingBuffer(5);
        Thread w = new Thread(() -> {
           for(int i =0; i < 100; i++) {
               buffer.write(i);
           }
        });
        Thread r = new Thread(() -> {
            for(int i =0; i < 100; i++) {
                buffer.read();
            }
        });
        w.start();
        r.start();
        w.join();
        r.join();
    }
}
