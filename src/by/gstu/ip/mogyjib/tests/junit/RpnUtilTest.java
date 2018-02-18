package by.gstu.ip.mogyjib.tests.junit;

import by.gstu.ip.mogyjib.utils.RpnUtil;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RpnUtilTest {
    @Test
    public void makeRpn_2plus6_return2_6_plus() {
        String[] expected = {"2", "6", "+"};
        String[] act = RpnUtil.makeRpn(new String[]{"2", "+", "6"});

        assertArrayEquals(expected, act);
    }

    @Test
    public void makeRpn_3plus6divide2withBracket_return3_6plus_2div() {
        String[] expected = {"3", "6", "+", "2", "/"};
        String[] act = RpnUtil.makeRpn(new String[]{"(", "3", "+", "6", ")", "/", "2"});

        assertArrayEquals(expected, act);
    }

    @Test
    public void makeRpn_3plus6divide2withoutBracket_return3_6_2div_plus() {
        String[] expected = {"3", "6", "2", "/", "+"};
        String[] act = RpnUtil.makeRpn(new String[]{"3", "+", "6", "/", "2"});

        assertArrayEquals(expected, act);
    }


    @Test
    public void makeRpn_3plusSin60divide2_return3_60_2div_sin_plus() {
        String[] expected = {"3", "60", "2", "/", "sin", "+"};
        String[] act = RpnUtil.makeRpn(new String[]{"3", "+", "sin", "(", "60", "/", "2", ")"});

        assertArrayEquals(expected, act);
    }
}
