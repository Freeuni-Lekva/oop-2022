public class MyConnection implements Connection {
    private static int counter = 0;
    private static Connection instance;

    private int id;

    private static boolean canNotReachDBIP() {
        return false;
    }

    private MyConnection(int id) {
        System.out.printf("TRYING TO CREATE CONNECTION %d\n", id);
        if (canNotReachDBIP()) {
            throw new RuntimeException("FOO");
        }
        this.id = id;
    }

    public static Connection getInstance()  {
        if (instance == null) {
            synchronized (MyConnection.class) {
                if (instance == null) {
                    counter++;
                    instance = new MyConnection(counter);
                }
            }
        }
        return instance;
    }

    public int getId() {
        return id;
    }
}
