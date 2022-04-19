import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySemaphore implements Semaphore {
    private int value;
    private Lock lock;
    private Condition cond;
    // private List<Condition> cond;

    public MySemaphore(int value) {
        this.value = value;
        lock = new ReentrantLock();
        cond = lock.newCondition();
        // cond = new ArrayList<>();
    }

    @Override
    public void acquire() throws InterruptedException {
        lock.lock();
        while (value == 0) {
//            Condition c = lock.newCondition();
//            cond.add(c);
//            c.await();
            cond.await();
        }
        value--;
        // System.out.printf("ACQUIRE %d\n", value);
        lock.unlock();
    }

    @Override
    public void release(int k) {
        lock.lock();
        value += k;
        // System.out.printf("RELEASE %d\n", value);
        cond.signalAll();
//        for (int i = 0; i < value; i++) {
//            if (cond.size() == 0) {
//                break;
//            }
//            Condition c = cond.get(cond.size() - 1);
//            cond.remove(c);
//            c.signal();
//        }
        lock.unlock();
    }
}
