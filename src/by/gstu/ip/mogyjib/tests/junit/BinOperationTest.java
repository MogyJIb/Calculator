package by.gstu.ip.mogyjib.tests.junit;

import by.gstu.ip.mogyjib.interfaces.BinOperationable;
import org.junit.Test;

import static by.gstu.ip.mogyjib.tests.JunitTestSuite.DELTA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BinOperationTest {


    @Test
    public void sum_2plus3_return5() {
        double expected = 5;
        double act = BinOperationable.SUM.calculate(2, 3);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void subtraction_5minus4_return1() {
        double expected = 1;
        double act = BinOperationable.SUBTRACTION.calculate(5, 4);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void division_15divide4_return3_75() {
        double expected = 3.75;
        double act = BinOperationable.DIVISION.calculate(15, 4);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void division_byZero_returnInfinite() {
        double result = BinOperationable.DIVISION.calculate(15, 0.0);
        boolean act = Double.isInfinite(result);
        assertTrue(act);
    }

    @Test
    public void percent_25from16_return4() {
        double expected = 4;
        double act = BinOperationable.PERCENT.calculate(25, 16);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void multiplication_2mult15_5_return31() {
        double expected = 31;
        double act = BinOperationable.MULTIPLICATION.calculate(2, 15.5);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void exponentiation_1_1pow2_return1_21() {
        double expected = 1.21;
        double act = BinOperationable.POW.calculate(1.1, 2);

        assertEquals(expected, act, DELTA);
    }
}
