package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket ss;

    public Server(int port) throws IOException {
        ss = new ServerSocket(port);
        System.out.println("Opened port");
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Waiting for clients");
                Socket s = ss.accept();
                System.out.println("Got new client.client");
                ClientProcessor p = new ClientProcessor(s);
                new Thread(p).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
