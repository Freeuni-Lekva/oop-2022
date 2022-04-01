package v2;

public class Main {
    public static void main(String[] args) {
        Node e = new PlusOperation(new ValueNode(1), new ValueNode(2));
        System.out.println(e.toString() + " = " + e.evaluate());
    }
}
