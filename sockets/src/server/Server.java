package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server<T> implements Runnable {
    private ServerSocket ss;
    private T obj;

    public Server(int port, T obj) throws IOException {
        this.obj = obj;
        ss = new ServerSocket(port);
        System.out.println("Opened port");
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Waiting for clients");
                Socket s = ss.accept();
                System.out.println("Got new client.client");
                ClientProcessor<T> p = new ClientProcessor<>(s, obj);
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
