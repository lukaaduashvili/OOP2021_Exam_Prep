package Sem14;

import java.util.concurrent.Semaphore;

public class RingBuffer {
    private int[] buffer;
    private int write_index;
    private int read_index;
    private MySemaphore empty;
    private MySemaphore full;

    public RingBuffer(int n) {
        write_index = 0;
        read_index = 0;
        buffer = new int[n];
        empty = new MySemaphore(n);
        full = new MySemaphore(0);
    }

    public void write(int x) {
        try {
            empty.acquire();
            buffer[write_index] = x;
            write_index = (write_index+1)%buffer.length;
            System.out.println("Wrote: " + x);
            full.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int read() {
        int ret = 0;
        try {
            full.acquire();
            ret = buffer[read_index];
            read_index = (read_index+1)%buffer.length;
            System.out.println("Read: " + ret);
            empty.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
