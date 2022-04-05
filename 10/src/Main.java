public class Main {
    public static void main(String[] args) {
        CalcBrain brain = new CalcBrain();
        // CalcView view = new GuiCalcView(); // new ConsoleView();
        CalcController controller = new CalcController(brain);
        controller.addView(new ConsoleView());
        controller.addView(new GuiCalcView());
        controller.start();
    }
}
