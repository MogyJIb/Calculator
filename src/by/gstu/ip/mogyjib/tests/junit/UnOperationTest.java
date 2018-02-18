package by.gstu.ip.mogyjib.tests.junit;


import by.gstu.ip.mogyjib.interfaces.UnOperationable;
import org.junit.Test;

import static by.gstu.ip.mogyjib.tests.JunitTestSuite.DELTA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UnOperationTest {

    @Test
    public void sinus_sin55_return0_81915() {
        double expected = 0.81915;
        double act = UnOperationable.SIN.calculate(55);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void cosinus_cos89_return0_01745() {
        double expected = 0.01745;
        double act = UnOperationable.COS.calculate(89);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void tangent_tg412_return1_27994() {
        double expected = 1.27994;
        double act = UnOperationable.TG.calculate(412);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void squareRoot_sqrt22_return4_69041() {
        double expected = 4.69041;
        double act = UnOperationable.SQRT.calculate(22);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void squareRoot_negative_returnNaN() {
        double result = UnOperationable.SQRT.calculate(-10);
        boolean act = Double.isNaN(result);
        assertTrue(act);
    }


}
