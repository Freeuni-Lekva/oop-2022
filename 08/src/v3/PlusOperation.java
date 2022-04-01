package v3;

public class PlusOperation extends BinaryOperation {
    public PlusOperation(Node left, Node right) {
        super(left, right);
    }

    @Override
    public double doEvaluate(double l, double r) {
        return l + r;
    }

    @Override
    public char getOperator() {
        return '+';
    }
}
