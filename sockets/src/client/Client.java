package client;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private Socket s;
    private ObjectInputStream inp;
    private ObjectOutputStream out;

    public Client(int port) throws IOException {
        s = new Socket("127.0.0.1", port);
        // TODO figure out order
        out = new ObjectOutputStream(s.getOutputStream());
        inp = new ObjectInputStream(s.getInputStream());
    }

    @Override
    public void run() {
        try {
            out.writeObject("add");
            out.flush();
            out.writeObject(Integer.valueOf(1));
            out.writeObject(Integer.valueOf(2));
            out.flush();
            Integer sum = (Integer) inp.readObject();
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject("distance");
            out.flush();
            out.writeObject(new Point(0, 0));
            out.writeObject(new Point(10, 10));
            out.flush();
            Double dist = (Double) inp.readObject();
            System.out.println(dist);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
