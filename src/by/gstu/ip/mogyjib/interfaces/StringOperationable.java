package by.gstu.ip.mogyjib.interfaces;

import by.gstu.ip.mogyjib.exceptions.IllegalFormatException;

/**
 * Created by Zhecka on 17.02.2018.
 */
public interface StringOperationable {
    double calculate(String expression) throws IllegalFormatException;
}
