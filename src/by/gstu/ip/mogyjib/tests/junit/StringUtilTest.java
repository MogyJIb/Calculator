package by.gstu.ip.mogyjib.tests.junit;

import by.gstu.ip.mogyjib.utils.StringUtil;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringUtilTest {
    @Test
    public void processUnMinus_emptyString_returnEmptyString() {
        String expected = "";
        String act = StringUtil.processUnMinus("");

        assertEquals(expected, act);
    }

    @Test
    public void processUnMinus_MinusAtStart_return0_Minus() {
        String expected = "0-1+3/2";
        String act = StringUtil.processUnMinus("-1+3/2");

        assertEquals(expected, act);
    }

    @Test
    public void processUnMinus_bracketMinus_returnBracket_0_Minus() {
        String expected = "5*(0-1+3/2)-(0-8)";
        String act = StringUtil.processUnMinus("5*(-1+3/2)-(-8)");

        assertEquals(expected, act);
    }

    @Test
    public void splitToOperands_2plus6_returnArray_3_operands() {
        String[] expected = {"2", "+", "6"};
        String[] act = StringUtil.splitToOperands("2+6");

        assertArrayEquals(expected, act);
    }

    @Test
    public void splitToOperands_3plus6divide2withBracket_returnArray_5_operands() {
        String[] expected = {"(", "3", "+", "6", ")", "/", "2"};
        String[] act = StringUtil.splitToOperands("(3+6)/2");

        assertArrayEquals(expected, act);
    }

    @Test
    public void splitToOperands_3plus6divide2withSpace_returnArray_5_operands() {
        String[] expected = {"(", "3", "+", "6", ")", "/", "2"};
        String[] act = StringUtil.splitToOperands("( 3 +6)/ 2");

        assertArrayEquals(expected, act);
    }

    @Test
    public void splitToOperands_3plusSin60divide2_returnArray_5_operands() {
        String[] expected = {"3", "+", "sin", "(", "60", "/", "2", ")"};
        String[] act = StringUtil.splitToOperands("3 + sin(60 / 2)");

        assertArrayEquals(expected, act);
    }

    @Test
    public void splitToOperands_emptyString_returnEmptyString() {
        String[] expected = {""};
        String[] act = StringUtil.splitToOperands("");

        assertArrayEquals(expected, act);
    }
}
