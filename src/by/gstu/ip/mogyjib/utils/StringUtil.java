package by.gstu.ip.mogyjib.utils;


/**
 * Utility which contain some static
 * methods to process string data.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class StringUtil {
    static final String CLOSE_BRACKET = ")";
    static final String OPEN_BRACKET = "(";

    /**
     * Process unary minus, reverse poland
     * notation can't process
     * unary minus like (-1), instead of it
     * change unary minus to (0-1).
     *
     * @param expression string expression
     * @return processed string
     */
    public static String processUnMinus(String expression){
        return expression
                .replaceAll("\\(-","(0-")
                .replaceAll("^-", "0-");
    }

    /**
     * Split string math expression to
     * separate operands (for example string
     * '2+4^sin(40)' will look like
     * ['2','+','4','^','sin','(','40',')'])
     *
     * @param expression string expression
     * @return array of operands
     */
    public static String[] splitToOperands(String expression){
        return  expression
                .replaceAll("(\\+|-|\\*|\\/|\\%|\\^|\\(|\\)|(\\w+\\.*\\w*))"," $1 ")
                .replaceAll("\\s+"," ")
                .trim()
                .split(" ");

    }
}
