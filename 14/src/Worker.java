import java.util.Random;

public class Worker implements Runnable {
    private static Random rand = new Random();

    private int id;
    private Semaphore s;


    public Worker(int id, Semaphore s) {
        this.id = id;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(rand.nextInt(100));
            s.acquire();
            System.out.printf("Worker %d started job\n", id);
            Thread.sleep(rand.nextInt(500));
            System.out.printf("Worker %d finished job\n", id);
            s.release(1);
            Thread.sleep(rand.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
