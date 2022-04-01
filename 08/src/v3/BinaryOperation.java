package v3;

public abstract class BinaryOperation implements Node {
    private Node left;
    private Node right;

    public BinaryOperation(Node left, Node right) {
        // Check for nulls
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        double l = left.evaluate();
        double r = right.evaluate();
        return doEvaluate(l, r);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + getOperator() + right.toString() + ")";
    }

    public abstract char getOperator();

    public abstract double doEvaluate(double l, double r);
}
