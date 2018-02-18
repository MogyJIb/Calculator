package by.gstu.ip.mogyjib.utils;


public class StringUtil {
    static final String CLOSE_BRACKET = ")";
    static final String OPEN_BRACKET = "(";

    public static String processUnMinus(String expression){
        return expression
                .replaceAll("\\(-","(0-")
                .replaceAll("^-", "0-");
    }
    public static String[] splitToOperands(String expression){
        return  expression
                .replaceAll("(\\+|-|\\*|\\/|\\%|\\^|\\(|\\)|(\\w+\\.*\\w*))"," $1 ")
                .replaceAll("\\s+"," ")
                .trim()
                .split(" ");

    }
}
