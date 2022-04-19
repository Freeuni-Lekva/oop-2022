import java.util.concurrent.locks.Lock;

public class RingBuffer<T> {
    private int capacity;
    private int writer_index;
    private int reader_index;
    private Object[] items;
    private Semaphore reader;  // 0
    private Semaphore writer;  // capacity

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
        reader = new MySemaphore(0);
        writer = new MySemaphore(capacity);
        writer_index = 0;
        reader_index = 0;
    }

    private int next(int index) {
        return (index + 1) % capacity;
    }

    public void write(T item) throws InterruptedException {
        writer.acquire();
        System.out.printf("WRITER %d\n", writer_index);
        items[writer_index] = item;
        writer_index = next(writer_index);
        reader.release(1);
    }

    public T read() throws InterruptedException {
        reader.acquire();
        System.out.printf("READER %d\n", reader_index);
        T ret = (T) items[reader_index];
        reader_index = next(reader_index);
        writer.release(1);
        return ret;
    }
}


//1 2 3  |   4 |               5 6
//________________________________________
//         1        2  3  4 |        5 6 |