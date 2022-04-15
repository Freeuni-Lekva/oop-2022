public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 100;
        Pair p = new Pair();
        // Pair q = new Pair();
        Thread[] workers = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            workers[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    p.inc();
                    // q.inc();
                }
            });
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(p.sum()); // + q.sum());
                    if (Thread.interrupted()) {
                        System.out.println("Thread.interrupted()");
                        throw new IllegalStateException("FOO");
                    }
//                    try {
//                        Thread.sleep(15);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
                }
            }
        });
        t.start();
//        for (int i = 0; i < numThreads; i++) {
//            workers[i].start();
//        }

        Thread.sleep(40);
        t.interrupt();

        for (int i = 0; i < numThreads; i++) {
            workers[i].join();
        }
        System.out.println(p.sum());
    }
}
