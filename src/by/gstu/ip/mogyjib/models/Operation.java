package by.gstu.ip.mogyjib.models;

import by.gstu.ip.mogyjib.interfaces.BinOperationable;
import by.gstu.ip.mogyjib.interfaces.UnOperationable;

import java.util.HashMap;
import java.util.Map;

import static by.gstu.ip.mogyjib.interfaces.BinOperationable.*;
import static by.gstu.ip.mogyjib.interfaces.UnOperationable.*;
import static by.gstu.ip.mogyjib.interfaces.UnOperationable.ZERO;

/**
 * The Operation class implements some math operations
 * storage. It contain all available math operations at the
 * program and their priority as static constants and
 * also contain some methods to compare and check it.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class Operation {
    //create and fill the operation's and priority's arrays.
    public static final Map<String, UnOperationable> UNARY = new HashMap<>();
    public static final Map<String, BinOperationable> BINARY = new HashMap<>();
    public static final Map<String, Integer> PRIORITIES = new HashMap<>();
    //constant of priorities.
    private static final int LOW_PRIORITY = 0;
    private static final int AVERAGE_PRIORITY = 1;
    private static final int HIGH_PRIORITY = 2;

    static {
        add("(",ZERO,HIGH_PRIORITY);
        add(")",ZERO,HIGH_PRIORITY);

        add("+", SUM, LOW_PRIORITY);
        add("-", SUBTRACTION, LOW_PRIORITY);
        add("%", PERCENT, LOW_PRIORITY);

        add("/", DIVISION, AVERAGE_PRIORITY);
        add("*", MULTIPLICATION, AVERAGE_PRIORITY);

        add("^", POW, HIGH_PRIORITY);
        add("tg", TG, HIGH_PRIORITY);
        add("sqrt", SQRT, HIGH_PRIORITY);
        add("cos", COS, HIGH_PRIORITY);
        add("sin", SIN, HIGH_PRIORITY);
    }

    /**
     * Method just add new unary operation to static Arrays (maps)
     * with operation inform like sign\spelling and priority.
     *
     * @param name      operation's sign\spelling, for example 'sqrt' or 'sin'
     * @param operation function with one argument which will
     *                  calculate this unary operation and return
     *                  the result
     * @param priority  priority of operation, should has one of static
     *                  constants
     * @see UnOperationable
     */
    private static void add(String name, UnOperationable operation, int priority) {
        UNARY.put(name,operation);
        PRIORITIES.put(name,priority);
    }

    /**
     * Method just add new binary operation to static Arrays (maps)
     * with operation inform like sign\spelling and priority.
     *
     * @param name      operation's sign\spelling, for example '+' or 'pow'
     * @param operation function with two arguments which will
     *                  calculate this binary operation and return
     *                  the result
     * @param priority  priority of operation, should has one of static
     *                  constants
     * @see BinOperationable
     */
    private static void add(String name, BinOperationable operation, int priority) {
        BINARY.put(name,operation);
        PRIORITIES.put(name,priority);
    }

    /**
     * Compare two operations by their priority, for example
     * operation '*' has bigger priority then operation '+'.
     *
     * @param first any operation's name like '+' or 'sin'
     * @param second any operation's name like 'tg' or '/'
     * @return the integer value, if first operation priority
     *          less then second's - return negative number,
     *          if first operation priority bigger then
     *          second's - return positive number,
     *          if equals - return 0
     */
    public static int compare(String first, String second){
        return Integer.compare(PRIORITIES.get(first),PRIORITIES.get(second));
    }

    /**
     * Check the operand\string is operation.
     *
     * @param operand any string
     * @return bool value, if array of operations has such
     *          operation return true, else return false
     */
    public static boolean isOperation(String operand){
        return BINARY.containsKey(operand)
                || UNARY.containsKey(operand);
    }
}
