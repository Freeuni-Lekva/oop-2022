public class Main {
    public static void main(String[] args) {
        Node e = new Node('+', new Node(1), new Node(2));
        System.out.println(e.toString() + " = " + e.evaluate());
    }
}
