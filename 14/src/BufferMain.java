public class BufferMain {
    public static void main(String[] args) throws InterruptedException {
        RingBuffer<Integer> buffer = new RingBuffer<>(5);
        Thread reader = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        int k = buffer.read();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        buffer.write(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        reader.start();
        writer.start();
        reader.join();
        writer.join();
    }
}
