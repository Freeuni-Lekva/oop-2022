public class BitmaskFilter implements Filter {
    private byte[] mask;
    private int size;

    public BitmaskFilter(int n) {
        mask = new byte[(n + 7) / 8];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isPresent(int index) {
        int x = index / 8;
        int y = index % 8;
        if ((mask[x] & (1 << y)) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void add(int index) {
        int x = index / 8;
        int y = index % 8;
        if ((mask[x] & (1 << y)) > 0) {
            return;
        }
        mask[x] |= (1 << y);
        ++size;
    }

    @Override
    public void remove(int index) {
        int x = index / 8;
        int y = index % 8;
        if ((mask[x] & (1 << y)) == 0) {
            return;
        }
        mask[x] ^= (1 << y);
        --size;
    }
}
