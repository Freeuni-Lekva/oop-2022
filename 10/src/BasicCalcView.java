import java.util.ArrayList;
import java.util.List;

public abstract class BasicCalcView implements CalcView {
    private List<UserInputListener> listeners;

    public BasicCalcView() {
        listeners = new ArrayList<>();
    }

    @Override
    public void addUserInputListener(UserInputListener listener) {
        listeners.add(listener);
    }

    protected void userEnteredInput(char input) {
        for (UserInputListener l : listeners) {
            l.inputEntered(input);
        }
    }
}
