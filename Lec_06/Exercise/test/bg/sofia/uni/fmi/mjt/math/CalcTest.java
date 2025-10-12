package test.bg.sofia.uni.fmi.mjt.math;

import bg.sofia.uni.fmi.mjt.math.Calc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {

    Calc calc = new Calc();

    @Test
    void testMultipleByZeroShouldReturnZero() {
        assertEquals(0, calc.multiply(10,0), "10 x must be 0");
    }

    @Test
    void testMultiplyZeroByXShouldReturnZero() {
        assertEquals(0, calc.multiply(0,10), "10 x must be 0");
    }

    @Test
    void testMultiplyZeroByZeroShouldReturnZero() {
        assertEquals(0, calc.multiply(0,0), "10 x must be 0");
    }

}
