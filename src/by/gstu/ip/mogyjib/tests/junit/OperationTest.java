package by.gstu.ip.mogyjib.tests.junit;

import by.gstu.ip.mogyjib.models.Operation;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OperationTest {
    @Test
    public void compare_plusAndMinus_return0() {
        boolean act = Operation.compare("+", "-") == 0;

        assertTrue(act);
    }

    @Test
    public void compare_plusAndDiv_returnNegative() {
        boolean act = Operation.compare("+", "*") < 0;

        assertTrue(act);
    }

    @Test
    public void compare_plusAndSin_returnNegative() {
        boolean act = Operation.compare("+", "sin") < 0;

        assertTrue(act);
    }

    @Test
    public void compare_cosAndSin_return0() {
        boolean act = Operation.compare("cos", "sin") == 0;

        assertTrue(act);
    }

    @Test
    public void compare_cosAndMul_returnPositive() {
        boolean act = Operation.compare("cos", "*") > 0;

        assertTrue(act);
    }

    @Test
    public void compare_mulAndminus_returnPositive() {
        boolean act = Operation.compare("*", "-") > 0;

        assertTrue(act);
    }

    @Test
    public void isOperation_minus_returnTrue() {
        boolean act = Operation.isOperation("-");

        assertTrue(act);
    }

    @Test
    public void isOperation_sharp_returnFalse() {
        boolean act = Operation.isOperation("#");

        assertFalse(act);
    }

    @Test
    public void isOperation_sin_returnTrue() {
        boolean act = Operation.isOperation("sin");

        assertTrue(act);
    }

    @Test
    public void isOperation_arctg_returnFalse() {
        boolean act = Operation.isOperation("arctg");

        assertFalse(act);
    }
}
