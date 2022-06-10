import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSequence<T> implements Sequence<T> {
    private List<T> elems;

    private class Iterator implements java.util.Iterator<T> {
        private int current;

        public Iterator() {
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < elems.size();
        }

        @Override
        public T next() {
            T ret = elems.get(current);
            current++;
            return ret;
        }
    }

    public ListSequence() {
        this.elems = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }

    public void add(T elem) {
        elems.add(elem);
    }
}
