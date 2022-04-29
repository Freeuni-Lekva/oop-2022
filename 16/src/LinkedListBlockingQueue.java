import java.util.*;
import java.util.concurrent.Semaphore;

public class LinkedListBlockingQueue<T> implements BlockingQueue<T> {
    private int capacity;
    private List<T> elems;
    Semaphore write;
    Semaphore read;

    public LinkedListBlockingQueue(int capacity) {
        this.capacity = capacity;
        write = new Semaphore(capacity);
        read = new Semaphore(0);
        elems = new LinkedList<>();
    }

    @Override
    public void push(T elem) {
        while (elems.size() == capacity) {
            try {
                write.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (elems) {
            elems.add(elem);
        }
        read.release();
    }

    @Override
    public boolean tryPush(T elem) {
        boolean acquired = write.tryAcquire();
        if (acquired) {
            synchronized (elems) {
                elems.add(elem);
            }
            read.release();
        }
        return acquired;
    }

    @Override
    public T remove() {
        while (elems.size() == 0) {
            try {
                read.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T elem = null;
        synchronized (elems) {
            elem = elems.remove(0);
        }
        write.release();
        return elem;
    }

    @Override
    public Optional<T> tryRemove() {
        boolean acquired = read.tryAcquire();
        T elem = null;
        synchronized (elems) {
            elem = elems.remove(0);
        }
        write.release();
        return elem;
    }
}
