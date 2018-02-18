package by.gstu.ip.mogyjib.interfaces;

import by.gstu.ip.mogyjib.utils.ConvertionUtil;

/**
 * The UnOperationable is functional interface
 * for different math unary operation that has only
 * one function - calculate, and used like
 * anonymous class and lambda.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public interface UnOperationable {
    //unary operations
    UnOperationable SIN = x -> Math.sin(ConvertionUtil.toRadians(x));
    UnOperationable COS = x -> Math.cos(ConvertionUtil.toRadians(x));
    UnOperationable TG = x -> Math.tan(ConvertionUtil.toRadians(x));
    UnOperationable SQRT = Math::sqrt;
    UnOperationable ZERO = x -> 0;

    /**
     * Method which just calculate some math unary operation.
     *
     * @param number any number
     * @return result of calculating
     */
    double calculate(double number);
}
