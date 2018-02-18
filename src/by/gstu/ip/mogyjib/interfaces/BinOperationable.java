package by.gstu.ip.mogyjib.interfaces;

/**
 * The BinOperationable is functional interface
 * for different math binary operation that has only
 * one function - calculate, and used like
 * anonymous class and lambda.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public interface BinOperationable {
    //binnary operations
    BinOperationable SUM = (x, y) -> (x + y);
    BinOperationable SUBTRACTION = (x, y) -> (x - y);
    BinOperationable DIVISION = (x, y) -> (x / y);
    BinOperationable MULTIPLICATION = (x, y) -> (x * y);
    BinOperationable PERCENT = (x, y) -> (x * y / 100);

    BinOperationable POW = Math::pow;
    BinOperationable ZERO = (x, y) -> 0;

    /**
     * Method which just calculate some math binary operation.
     *
     * @param firstNumber  any number
     * @param secondNumber any number
     * @return result of calculating
     */
    double calculate(double firstNumber, double secondNumber);
}
