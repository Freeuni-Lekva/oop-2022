import java.util.Arrays;

public class MyStack<T> {
    private Object[] items;
    private int logLen;

    public MyStack() {
        items = new Object[4];
        logLen = 0;
    }

    public void push(T item) {
        if (logLen == items.length) {
            items = Arrays.copyOf(items, 2 * items.length);
        }
        items[logLen] = item;
        ++logLen;
    }

    public T pop() {
        if (logLen == 0) {
            throw new PopOnEmptyStackException();
        }
        --logLen;
        return (T) items[logLen];
    }
}
