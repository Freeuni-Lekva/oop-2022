package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private Socket s;
    private Scanner inp;
    private PrintWriter out;

    public Client(int port) throws IOException {
        s = new Socket("127.0.0.1", port);
        inp = new Scanner(s.getInputStream());
        out = new PrintWriter(s.getOutputStream());
    }

    @Override
    public void run() {
        out.write("add\n1\n2\n");
        out.flush();
        System.out.printf("1 + 2 = %s\n", inp.next());
        System.out.println("asdasdasd");
//        for (int i = 0; i < 100; i++) {
//            out.write(i);
//            out.write("\n");
//            out.flush();
//            String data = inp.next();
//            System.out.printf("GOT BACK %s\n", data);
//        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
