import java.io.IOException;

public class ConsoleView extends BasicCalcView {
    @Override
    public void displayChanged(String display) {
        System.out.println(">>> " + display);
    }

    @Override
    public void show() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(">>> 0");
                while (true) {
                    try {
                        byte[] bytes = System.in.readNBytes(1);
                        if (bytes.length >= 1) {
                            char input = (char) bytes[0];
                            userEnteredInput(input);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ).start();
    }
}