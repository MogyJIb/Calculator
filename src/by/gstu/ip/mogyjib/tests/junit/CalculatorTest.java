package by.gstu.ip.mogyjib.tests.junit;

import by.gstu.ip.mogyjib.exceptions.IllegalFormatException;
import by.gstu.ip.mogyjib.models.Calculator;
import by.gstu.ip.mogyjib.utils.RpnUtil;
import by.gstu.ip.mogyjib.utils.StringUtil;
import org.junit.Test;

import static by.gstu.ip.mogyjib.tests.JunitTestSuite.DELTA;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test(expected = IllegalFormatException.class)
    public void processRpnExpression_unknownOperation_throwException()
            throws IllegalFormatException {
        String expression = "3$5-1/12+sin(40)";
        String[] operands = RpnUtil.makeRpn(StringUtil.splitToOperands(expression));
        double act = Calculator.processRpnExpression(operands);
    }

    @Test(expected = IllegalFormatException.class)
    public void processRpnExpression_wrongNumberFormat_throwException()
            throws IllegalFormatException {
        String expression = "3,215-1/12a+sin(40)";
        String[] operands = RpnUtil.makeRpn(StringUtil.splitToOperands(expression));
        double act = Calculator.processRpnExpression(operands);
    }

    @Test(expected = IllegalFormatException.class)
    public void processRpnExpression_wrongArgsCount_throwException()
            throws IllegalFormatException {
        String expression = "3215-1/12a+sin(40*)";
        String[] operands = RpnUtil.makeRpn(StringUtil.splitToOperands(expression));
        double act = Calculator.processRpnExpression(operands);
    }

    @Test(expected = IllegalFormatException.class)
    public void processRpnExpression_emptyString_throwException()
            throws IllegalFormatException {
        String expression = "";
        String[] operands = RpnUtil.makeRpn(StringUtil.splitToOperands(expression));
        double act = Calculator.processRpnExpression(operands);
    }

    @Test
    public void calculateSimpleExpression_2plus6_5_return8()
            throws IllegalFormatException {
        double expected = 8.5;
        double act = Calculator.calculateSimpleExpression("2+6.5");

        assertEquals(expected, act, DELTA);
    }

    @Test(expected = IllegalFormatException.class)
    public void calculateSimpleExpression_wrongArgsCount_throwException()
            throws IllegalFormatException {
        String expression = "2+";
        double act = Calculator.calculateSimpleExpression(expression);
    }

    @Test
    public void calculateComplexExpression_7plus6divide2withBracket_return6_5()
            throws IllegalFormatException {
        double expected = 6.5;
        double act = Calculator.calculateComplexExpression("(7+6)/2");

        assertEquals(expected, act, DELTA);
    }


    @Test
    public void calculateComplexExpression_3plusSin60divide2_return4_5()
            throws IllegalFormatException {
        double expected = 3.5;
        double act = Calculator.calculateComplexExpression("3 + sin(60 / 2)");

        assertEquals(expected, act, DELTA);
    }


}
