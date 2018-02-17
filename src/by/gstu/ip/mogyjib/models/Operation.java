package by.gstu.ip.mogyjib.models;

import by.gstu.ip.mogyjib.interfaces.BinOperationable;
import by.gstu.ip.mogyjib.interfaces.UnOperationable;

import java.util.HashMap;
import java.util.Map;

import static by.gstu.ip.mogyjib.interfaces.BinOperationable.*;
import static by.gstu.ip.mogyjib.interfaces.UnOperationable.*;
import static by.gstu.ip.mogyjib.interfaces.UnOperationable.ZERO;
import static by.gstu.ip.mogyjib.utils.StringUtil.CLOSE_BRACKET;
import static by.gstu.ip.mogyjib.utils.StringUtil.OPEN_BRACKET;


public class Operation {
    public static final int LOW_PRIORITY = 0;
    public static final int AVERAGE_PRIORITY = 1;
    public static final int HIGH_PRIORITY = 2;

    public static final Map<String, UnOperationable> UNARY = new HashMap<>();
    public static final Map<String, BinOperationable> BINARY = new HashMap<>();
    public static final Map<String, Integer> PRIORITIES = new HashMap<>();

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

    private static void add(String name,UnOperationable operation,int priority){
        UNARY.put(name,operation);
        PRIORITIES.put(name,priority);
    }
    private static void add(String name,BinOperationable operation,int priority){
        BINARY.put(name,operation);
        PRIORITIES.put(name,priority);
    }


    public static int compare(String first, String second){
        return Integer.compare(PRIORITIES.get(first),PRIORITIES.get(second));
    }

    public static boolean isOperation(String operand){
        return BINARY.containsKey(operand)
                || UNARY.containsKey(operand);
    }
}
