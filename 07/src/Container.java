import java.util.Comparator;

public interface Container<T extends Comparable<T>> {
    public int size();
    public T get(int index);
    public void set(int index, T value);

    public default T findMax(/* Comparator<T> cmp */) {
        if (size() == 0) {
            return null;
        }
        T m = get(0);
        for (int i = 1; i < size(); i++) {
            if (m.compareTo(get(i)) < 0) {
                m = get(i);
            }
        }
        return m;
    }
}
