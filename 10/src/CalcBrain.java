import java.util.ArrayList;
import java.util.List;

public class CalcBrain {
    private List<DisplayChangeListener> listeners;

    private String display;
    private String prevDisplay;
    private char operator;
    private boolean shouldClear;

    public CalcBrain() {
        listeners = new ArrayList<>();
        display = "";
        prevDisplay = "";
        operator = '\0';
        shouldClear = false;
    }

    public void addDisplayChangeListener(DisplayChangeListener listener) {
        listeners.add(listener);
    }

    private void fireAllDisplayChangeListeners() {
        for (DisplayChangeListener l : listeners) {
            l.displayChanged(display);
        }
    }

    private void updateDisplay(String display) {
        this.display = display;
        fireAllDisplayChangeListeners();
    }

    void digitEntered(char digit) {
//        System.out.println("#### " + prevDisplay);
//        System.out.println("#### " + display);
//        System.out.println("#### " + operator);
//        System.out.println("#### " + shouldClear);
        if (shouldClear) {
            prevDisplay = display;
            shouldClear = false;
            updateDisplay(String.valueOf(digit));
        } else {
            updateDisplay(display + digit);
        }
    }

    void operationEntered(char operator) {
        this.operator = operator;
        shouldClear = true;
    }

    void evaluate() {
        switch (operator) {
            case '+':
                updateDisplay(
                        String.valueOf(Double.valueOf(prevDisplay) + Double.valueOf(display)));
                break;
            case '-':
                updateDisplay(
                        String.valueOf(Double.valueOf(prevDisplay) - Double.valueOf(display)));
                break;
            case '*':
                updateDisplay(
                        String.valueOf(Double.valueOf(prevDisplay) * Double.valueOf(display)));
                break;
            case '/':
                updateDisplay(
                        String.valueOf(Double.valueOf(prevDisplay) / Double.valueOf(display)));
                break;
            default:
                throw new IllegalStateException("Illegal operatort detected: " + operator);
        }
    }
}
