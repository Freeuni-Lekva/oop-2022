package v3;

public class MinusOperation extends BinaryOperation {
    public MinusOperation(Node left, Node right) {
        super(left, right);
    }

    @Override
    public double doEvaluate(double l, double r) {
        return l - r;
    }

    @Override
    public char getOperator() {
        return '-';
    }
}
