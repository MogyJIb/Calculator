package by.gstu.ip.mogyjib.interfaces;

public interface BinOperationable {
    BinOperationable SUM = (x,y) -> (x+y);
    BinOperationable SUBTRACTION = (x,y) -> (x-y);
    BinOperationable DIVISION = (x,y) -> (x/y);
    BinOperationable MULTIPLICATION = (x,y) -> (x*y);
    BinOperationable PERCENT = (x,y) -> (x*y/100);

    BinOperationable POW = Math::pow;
    BinOperationable ZERO = (x,y) -> 0;

    double calculate(double firstNumber,double secondNumber);
}
