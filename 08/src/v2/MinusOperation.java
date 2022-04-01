package v2;

public class MinusOperation implements Node {
    private Node left;
    private Node right;

    public MinusOperation(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}
