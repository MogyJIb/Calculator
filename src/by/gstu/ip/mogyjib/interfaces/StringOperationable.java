package by.gstu.ip.mogyjib.interfaces;

import by.gstu.ip.mogyjib.exceptions.IllegalFormatException;

/**
 * The StringOperationable is functional interface
 * that has only one function - calculate, and used like
 * anonymous class and lambda to solve math equation
 * which was written like string.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public interface StringOperationable {
    /**
     * Method which calculate any math equation.
     * Equation should be written like string
     *
     * @param expression any string -  math equation
     * @return result of calculating
     */
    double calculate(String expression) throws IllegalFormatException;
}
