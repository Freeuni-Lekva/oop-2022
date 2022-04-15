import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pair {
    private Lock lock;
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
        lock = new ReentrantLock();
    }

    public Pair() {
        this(0, 0);
    }

    public synchronized void inc() {
        // lock.lock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            a++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b++;
        // lock.unlock();
    }

    public synchronized int sum() {
        // lock.lock();
        int ret = a + b;
        // lock.unlock();
        return ret;
    }
}
