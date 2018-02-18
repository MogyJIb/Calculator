package by.gstu.ip.mogyjib.tests;

import by.gstu.ip.mogyjib.tests.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BinOperationTest.class,
        UnOperationTest.class,
        ConvertionUtilTest.class,
        StringUtilTest.class,
        RpnUtilTest.class,
        CalculatorTest.class,
        OperationTest.class
})
public class JunitTestSuite {
    public static final double DELTA = 1e-5;
}
