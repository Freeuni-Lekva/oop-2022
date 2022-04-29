public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new LinkedListBlockingQueue<>(100);
        Thread t[] = new Thread[100];
        for (int i = 0; i < 100; i++) {
            t[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        q.push(i);
                    }
                }
            });
            t[i].start();
        }
        for (int i = 0; i < 100; i++) {
            t[i].join();
        }
        for (int i = 0; i < 101; i++) {
            System.out.println(q.remove());
            System.out.printf("--- %d\n", i);
        }
    }
}
