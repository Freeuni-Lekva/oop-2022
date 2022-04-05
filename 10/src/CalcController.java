import java.util.*;

public class CalcController implements UserInputListener {
    private CalcBrain brain;
    private List<CalcView> views;

    public CalcController(CalcBrain brain) {
        this.brain = brain;
        views = new ArrayList<>();
    }

    public void addView(CalcView view) {
        views.add(view);
        brain.addDisplayChangeListener(view);
        view.addUserInputListener(this);
    }

    @Override
    public void inputEntered(char input) {
        if ('0' <= input && input <= '9') {
            brain.digitEntered(input);
        } else if (input == '=') {
            brain.evaluate();
        } else if ("+-*/".indexOf(input) != -1){
            brain.operationEntered(input);
        }
    }

    public void start() {
        for (CalcView view : views) {
            view.show();
        }
    }
}
