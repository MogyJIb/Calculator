package by.gstu.ip.mogyjib.interfaces;

import by.gstu.ip.mogyjib.exceptions.IllegalFormatException;


public interface StringOperationable {
    double calculate(String expression) throws IllegalFormatException;
}
