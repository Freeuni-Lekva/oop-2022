import org.junit.Test;

public class BitmaskFilterTest {

    @Test
    public void singleIndex() {
        Filter f = new BitmaskFilter(10);
        if (f.isPresent(5)) {
            throw new RuntimeException("TEST FAILED");
        }
        f.add(5);
        if (!f.isPresent(5)) {
            throw new RuntimeException("TEST FAILED");
        }
        if (f.size() != 1) {
            throw new RuntimeException("TEST FAILED");
        }
        f.remove(5);
        if (f.isPresent(5)) {
            throw new RuntimeException("TEST FAILED");
        }
        if (f.size() != 0) {
            throw new RuntimeException("TEST FAILED");
        }
    }

    @Test
    public void many() {
        Filter f = new BitmaskFilter(100);
        for (int i = 0; i < 100; i++) {
            assert(f.size() == i);
            assert(!f.isPresent(i));
            f.add(i);
            assert(f.isPresent(i));
            assert(f.size() == i + 1);
        }
    }
}
