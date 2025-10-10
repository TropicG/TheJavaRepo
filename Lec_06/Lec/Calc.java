import org.juint.jupiter.api.Test;
import static org.juint.juint.api.Assertions.assertEquals;

public class Calc {
    public int multiply(int a, int b) {
        return a * b;
    }
}

class CalcTest {

    @Test
    void testMultiplyByZeroShouldReturnZero() {
        Calc calc = new Calc();

        assertEquals(0, calc.multiply(10,0), "10 x 0 must be 0");
        assertEquals(0, calc.multiply(0, 10), "0 x 10 must be 0");
        assertEquals(0, calc.multiply(0, 0), "0 x 0 must be 0");
    }
}