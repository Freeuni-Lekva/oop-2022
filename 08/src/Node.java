import java.security.InvalidParameterException;

public class Node {
    private double value;
    private char operator;
    private Node left;
    private Node right;

    public Node(double value) {
        this.value = value;
    }

    public Node(char operator, Node left, Node right) {
        if (operator == Character.MIN_VALUE) {
            throw new InvalidParameterException("Unknown operator: " + operator);
        }
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public double evaluate() {
        if (operator == Character.MIN_VALUE) {
            return value;
        }
        switch (operator) {
            case '+':
                return left.evaluate() + right.evaluate();
            case '-':
                return left.evaluate() - right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            case '/':
                return left.evaluate() / right.evaluate();
            default:
                throw new IllegalStateException("Unknown operator: " + operator);
        }
    }

    @Override
    public String toString() {
        if (operator == Character.MIN_VALUE) {
            return String.valueOf(value);
        }
        return "(" + left.toString() + operator + right.toString() + ")";
    }
}
