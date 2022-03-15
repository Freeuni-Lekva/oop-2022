import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void testFizz() {
        String x = FizzBuzz.convert(6);
        Assertions.assertEquals("Fizz", x);
    }

    @Test
    public void testBuzz() {
        String x = FizzBuzz.convert(10);
        Assertions.assertEquals("Buzz", x);
    }

    @Test
    public void testFizzBuzz() {
        String x = FizzBuzz.convert(30);
        Assertions.assertEquals("FizzBuzz", x);
    }

    @Test
    public void testNotFizzBuzz() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                FizzBuzz.convert(13);
            }
        });
//        String x = FizzBuzz.convert(13);
//        Assertions.assertEquals("13", x);
    }

    @Test
    public void testZero() {
        String x = FizzBuzz.convert(0);
        Assertions.assertEquals("FizzBuzz", x);
    }
}
