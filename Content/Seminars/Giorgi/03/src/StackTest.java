import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StackTest {
    @Test
    public void test() {
        MyStack<Integer> s = new MyStack<>();
        s.push(5);
        s.push(3);
        s.push(10);
        Assertions.assertEquals(10, s.pop());
        Assertions.assertEquals(3, s.pop());
        Assertions.assertEquals(1, s.length());
    }
}
