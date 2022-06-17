package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientProcessor implements Runnable {
    private Socket s;
    private Scanner inp;
    private PrintWriter out;

    public ClientProcessor(Socket s) throws IOException {
        this.s = s;
        inp = new Scanner(s.getInputStream());
        out = new PrintWriter(s.getOutputStream());
    }

    @Override
    public void run() {
        Math m = new Math();
        while (true) {
            String op = inp.next();
            System.out.println(op);
            switch (op) {
                case "add": {
                    Integer a = Integer.valueOf(inp.next());
                    Integer b = Integer.valueOf(inp.next());
                    Integer o = m.add(a, b);
                    out.write(String.valueOf(o));
                    System.out.println(o);
                    break;
                }
                case "subtract": {
                    Integer a = Integer.valueOf(inp.next());
                    Integer b = Integer.valueOf(inp.next());
                    Integer c = Integer.valueOf(inp.next());
                    Integer o = m.subtract(a, b, c);
                    out.write(String.valueOf(o));
                    break;
                }
                default:
                    out.write("ERROR INVALID OPERATION");
            }
            out.flush();
//            System.out.printf("SERVER: %s\n", data);
//            out.write(data);
//            out.write("\n");
//            out.flush();
        }
//        System.out.println("Closed connection");
//        try {
//            s.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
