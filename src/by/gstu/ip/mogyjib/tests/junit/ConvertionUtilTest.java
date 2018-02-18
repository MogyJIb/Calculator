package by.gstu.ip.mogyjib.tests.junit;

import by.gstu.ip.mogyjib.utils.ConvertionUtil;
import org.junit.Test;

import static by.gstu.ip.mogyjib.tests.JunitTestSuite.DELTA;
import static org.junit.Assert.assertEquals;

public class ConvertionUtilTest {
    @Test
    public void toRadian_412_return7_19075() {
        double expected = 7.19075;
        double act = ConvertionUtil.toRadians(412);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void toRadian_0_return0() {
        double expected = 0.0;
        double act = ConvertionUtil.toRadians(0);

        assertEquals(expected, act, DELTA);
    }

    @Test
    public void parseDouble_0_150497_return0_1505() {
        String expected = "0.1505";
        String act = ConvertionUtil.parseDouble(0.150497);

        assertEquals(expected, act);
    }

    @Test
    public void parseDouble_2_15000_return2_15() {
        String expected = "2.15";
        String act = ConvertionUtil.parseDouble(2.15000);

        assertEquals(expected, act);
    }
}
