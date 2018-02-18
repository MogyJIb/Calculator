package by.gstu.ip.mogyjib.utils;

import by.gstu.ip.mogyjib.interfaces.StringOperationable;

import java.io.*;

/**
 * Utility to process input file with
 * data of math expression, solve each of them
 * and write to output file.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class TaskUtil {
    /**
     * Static variable which present
     * rewrite file or append.
     */
    private final  boolean append = false;
    private StringOperationable function;

    /**
     * Constructor.
     *
     * @param function function with one string parameter
     *                 which will solve the equation.
     */
    public TaskUtil(StringOperationable function) {
        this.function = function;
    }

    public StringOperationable getFunction() {
        return function;
    }

    public boolean isAppend() {
        return append;
    }

    /**
     * Read file of expressions by line,
     * solve each of them and write answer
     * to output file. If some exception -
     * write their massage also to file.
     *
     * @param readFileName  input file name
     * @param writeFileName output file name
     * @throws IOException some exception of
     *                     open\read\write file
     */
    public void make(String readFileName, String writeFileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeFileName, append));
             BufferedReader br = new BufferedReader(new FileReader(readFileName))) {
            String expression;
            double res;
            while((expression=br.readLine())!=null){
                try {
                    res = function.calculate(expression);
                    bw.write(makeAnswer(expression, res));
                } catch (Exception ex) {
                    bw.write(ex.getMessage());
                }
                bw.newLine();
            }
        }
    }

    /**
     * Make answer to write from
     * initial expression end result value
     * or exceptions massage (answer like
     * '2+5^2=27' or 'Division by zero').
     *
     * @param expression input expression
     * @param result     double result
     * @return string answer to write to file
     * @throws ArithmeticException some wrong string
     *                             format exception
     * @see ConvertionUtil
     */
    public String makeAnswer(String expression, double result)
            throws ArithmeticException {

        if (Double.isInfinite(result))
            throw new ArithmeticException("Division by zero.");

        if (Double.isNaN(result))
            throw new ArithmeticException("Square root should has positive number.");

        StringBuilder text = new StringBuilder();
        text.append(expression);
        text.append("=");
        text.append(ConvertionUtil.parseDouble(result));
        return text.toString();
    }
}
