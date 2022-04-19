public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 100;
        Thread t[] = new Thread[n];
        Semaphore s = new MySemaphore(3);
        for (int i = 0; i < n; i++) {
            t[i] = new Thread(new Worker(i, s));
        }
        for (int i = 0; i < n; i++) {
            t[i].start();
        }
        for (int i = 0; i < n; i++) {
            t[i].join();
        }
    }
}
