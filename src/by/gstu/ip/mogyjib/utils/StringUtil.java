package by.gstu.ip.mogyjib.utils;


public class StringUtil {
    public static final String CLOSE_BRACKET = ")";
    public static final String OPEN_BRACKET = "(";

    public static String processUnMinus(String expression){
        return expression
                .replaceAll("\\(-","(0-")
                .replaceAll("\b-","0-");
    }
    public static String[] splitToOperands(String expression){
        return  expression
                .replaceAll("(\\+|-|\\*|/|%|^|\\(|\\)|\\w+)"," $1 ")
                .replaceAll("\\s+"," ")
                .trim()
                .split(" ");

    }
}
