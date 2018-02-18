package by.gstu.ip.mogyjib.exceptions;

/**
 * The IllegalFormatException class implements
 * my own exceptions for wrong format of inputted
 * strings (equations).
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class IllegalFormatException extends Exception {
    public IllegalFormatException(String massage){
        super(massage);
    }
}
