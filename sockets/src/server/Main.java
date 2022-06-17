package server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server s = new Server(4321);
        s.run();
    }
}
