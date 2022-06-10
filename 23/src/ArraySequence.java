import java.util.Iterator;

public class ArraySequence<T> implements Sequence<T> {
    private T[] elems;

    private class Iterator implements java.util.Iterator<T> {
        private int current;

        public Iterator() {
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < elems.length;
        }

        @Override
        public T next() {
            T ret = elems[current];
            current++;
            return ret;
        }
    }

    public ArraySequence(T[] elems) {
        this.elems = elems;
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }
}
