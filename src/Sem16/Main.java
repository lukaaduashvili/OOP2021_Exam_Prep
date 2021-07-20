package Sem16;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class Cell implements Runnable {
    private boolean[][] grid;
    private int x;
    private int y;
    private int numIter;
    private CyclicBarrier iterFinished;
    private CountDownLatch latch;

    public Cell(boolean[][] grid, int x, int y, int numIter, CyclicBarrier iterFinished, CountDownLatch latch) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.numIter = numIter;
        this.iterFinished = iterFinished;
        this.latch = latch;
    }

    @Override
    public void run() {
        for(int i = 0; i < numIter; i++) {
                boolean newState = calculateStateAfterIteration();
            try {
                iterFinished.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            grid[x][y] = newState;
        }
        latch.countDown();
    }

    private boolean calculateStateAfterIteration() {
        int liveNeighbours = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1 ; dy++) {
                final int nx = x+dx;
                final int ny = y+dy;
                if(0 <= nx && nx <grid.length && 0 <= ny && ny < grid[0].length) {
                    if(grid[nx][ny])
                        liveNeighbours++;
                }
            }
        }
        if(grid[x][y])
            liveNeighbours--;
        boolean newState = false;
        if(grid[x][y] && (liveNeighbours == 2 || liveNeighbours == 3))
            newState = true;
        else if(!grid[x][y] && liveNeighbours == 3)
            newState = true;
        return newState;
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int n = 5;
        final int m = 5;
        final int numIter = 20;
        boolean[][] grid = createInitGrid(n, m);
        //Thread[][] cells = new Thread[n][m];
        Runnable iterPrinter = () ->{
            System.out.println("===============================");
            System.out.println();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(grid[i][j])
                        System.out.printf("*");
                    else
                        System.out.printf(".");
                }
                System.out.println();
            }
            System.out.println();
        };
        final CyclicBarrier iterFinished = new CyclicBarrier(n*m, iterPrinter);
        final CountDownLatch allFinished = new CountDownLatch(n*m);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //cells[i][j] = new Thread(new Cell(grid, i, j, numIter, iterFinished));
                //cells[i][j].start();
                new Thread(new Cell(grid, i, j, numIter, iterFinished, allFinished)).start();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //cells[i][j].join();
            }
        }
        allFinished.await();
        iterPrinter.run();
    }

    private static boolean[][] createInitGrid(int n, int m) {
        Random r = new Random();
        boolean[][] grid = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = r.nextBoolean();
            }
        }
        return grid;
    }
}
