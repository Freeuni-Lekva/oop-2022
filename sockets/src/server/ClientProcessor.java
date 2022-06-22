package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Scanner;

public class ClientProcessor<T> implements Runnable {
    private Socket s;
    private T obj;
    private ObjectInputStream inp;
    private ObjectOutputStream out;

    public ClientProcessor(Socket s, T obj) throws IOException {
        this.s = s;
        this.obj = obj;
        inp = new ObjectInputStream(s.getInputStream());
        out = new ObjectOutputStream(s.getOutputStream());
    }

    private void processOperation(String name) throws NoSuchMethodException, IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Method op = null;
        for (Method x : obj.getClass().getMethods()) {
            if (x.getName().equals(name)) {
                op = x;
                break;
            }
        }
        if (op == null) {
            return; // better return error in output stream
        }
        Object[] args = new Object[op.getParameterCount()];
        for (int i = 0; i < op.getParameterCount(); i++) {
            args[i] = inp.readObject();
        }
        Object ret = op.invoke(obj, args);
        System.out.println(ret);
        out.writeObject(ret);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String op = (String) inp.readObject();
                System.out.printf("RECEIVE OP %s\n", op);
                processOperation(op);
                out.flush();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
//            switch (op) {
//                case "add": {
//                    Integer a = Integer.valueOf(inp.next());
//                    Integer b = Integer.valueOf(inp.next());
//                    Integer o = m.add(a, b);
//                    out.write(String.valueOf(o));
//                    out.flush();
//                    System.out.println(o);
//                    break;
//                }
//                case "subtract": {
//                    Integer a = Integer.valueOf(inp.next());
//                    Integer b = Integer.valueOf(inp.next());
//                    Integer c = Integer.valueOf(inp.next());
//                    Integer o = m.subtract(a, b, c);
//                    out.write(String.valueOf(o));
//                    break;
//                }
//                default:
//                    out.write("ERROR INVALID OPERATION");
//            }
//            out.flush();
//            System.out.printf("SERVER: %s\n", data);
//            out.write(data);
//            out.write("\n");
//            out.flush();
        }
        System.out.println("Closed connection");
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
