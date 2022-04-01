import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayContainer<T extends Comparable<T>> implements Container<T> {
    private Object[] items;

    public ArrayContainer(int n) {
        items = new Object[n];
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public T get(int index) {
        return (T) items[index];
    }

    @Override
    public void set(int index, T value) {
        items[index] = value;
    }

    @Override
    public T findMax(/* Comparator<T> cmp */) {
        return get(0);
    }
}
