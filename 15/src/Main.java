import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int n = 100;
        CountDownLatch l = new CountDownLatch(n);
        for (int i = 0; i < n; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MyConnection.getInstance();
                    // System.out.println(MyConnection.getInstance().getId());
                    l.countDown();
                }
            }).start();
        }
        l.await();
    }
}
