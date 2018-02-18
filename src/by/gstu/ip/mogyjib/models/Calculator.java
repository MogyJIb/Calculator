package by.gstu.ip.mogyjib.models;


import by.gstu.ip.mogyjib.exceptions.IllegalFormatException;
import by.gstu.ip.mogyjib.utils.RpnUtil;
import by.gstu.ip.mogyjib.utils.StringUtil;

import java.util.Stack;

/**
 * The Calculator class is instance which will make
 * and process all math operation and check errors.
 * <p>
 * Can calculate some simple unary and binary operation
 * by operation name, also can solve complex math
 * equations which is written in string format.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class Calculator {
    /**
     * Method which just calculate some math binary operation
     * by operation name, method of solving is chosen from
     * static constants of operation Operation's class (BINARY).
     *
     * @param first  any number
     * @param second any number
     * @return result of calculating
     * @see Operation
     */
    public static double calculate(String operation, double first, double second) {
        return Operation.BINARY.get(operation).calculate(first,second);
    }

    /**
     * Method which just calculate some math unary operation
     * by operation name, method of solving is chosen from
     * static constants of operation Operation's class (UNARY).
     *
     * @param first any number
     * @return result of calculating
     * @see Operation
     */
    public static double calculate(String operation, double first){
        return Operation.UNARY.get(operation).calculate(first);
    }

    /**
     * Calculate some simple expression like
     * string '2*15' or '2^8'. It get equation as parameter
     * and then parse it to operands in form of two
     * numbers and one operation and solve it, if
     * can't do some parsing or solving it get
     * throw exception.
     *
     * @param expression any string to solve (for
     *                   example '10/4' or '9-22')
     * @return double value - solving of expression
     * @throws IllegalFormatException some wrong string
     *                                format exception
     * @see StringUtil
     */
    public static double calculateSimpleExpression(String expression)
            throws IllegalFormatException {
        if (expression.isEmpty())
            throw new IllegalFormatException("Empty line.");

        String[] operands = StringUtil.splitToOperands(expression);
        if (operands.length < 3)
            throw new IllegalFormatException("Binary operator " +
                    "should has two arguments.");

        double first=0,second =0;
        String operation = operands[1];
        try {
            first = Double.parseDouble(operands[0]);
            second = Double.parseDouble(operands[2]);
        } catch (Exception ex) {
            throw new IllegalFormatException("Wrong number's format: '"
                    + first + "', '" + second + "'.");
        }

        return calculate(operation,first,second);
    }

    /**
     * Calculate some complex expression like
     * string (for example '2*15 - sin(100)^(8/3)'.
     * It get equation as parameter
     * and then split it to operands and solve it
     * (splitting and solving make as reverse poland
     * notation), if can't do some parsing or
     * solving it get throw exception.
     *
     * @param expression any string to solve (for
     *                   example '10-17*cos(2^6)')
     * @return double value - solving of expression
     * @throws IllegalFormatException some wrong string
     *                                format exception
     * @see StringUtil,RpnUtil
     */
    public static double calculateComplexExpression(String expression)
            throws IllegalFormatException {
        if (expression.isEmpty())
            throw new IllegalFormatException("Empty line.");


        // process unary minus like '-1'
        expression = StringUtil.processUnMinus(expression);


        //split to array of operands ('1','+','6')
        String[] operands = StringUtil.splitToOperands(expression);

        /*
          make array of operands like reverse
          poland notation  ('1','6','+')
        */
        String[] operandsRpn = RpnUtil.makeRpn(operands);

        //process this array and return result
        return processRpnExpression(operandsRpn);
    }

    /**
     * Process the equation in reverse poland
     * notation (postfix notation). Get array
     * of operands and then solve it.
     *
     * Each operand puts to stack while it isn't operation,
     * but when it's operation operands pop from stack
     * and make the operation and put result back
     * to stack. When operands end result will be
     * on the top of stack.
     *
     * @param operands array of operands in postfix form
     *                 (form of reverse poland notation,
     *                 for example '2+3' will be
     *                 like ('2','3','+'))
     * @return double value - result of expression
     * @throws IllegalFormatException some wrong string
     *                                format exception
     */
    public static double processRpnExpression(String[] operands)
            throws IllegalFormatException {
        if (operands == null || operands.length == 0)
            throw new IllegalFormatException("Inputted string is empty.");

        //result stack
        Stack<Double> processingStack = new Stack<>();
        for (String operand : operands) {
            //if operation is binary
            if (Operation.BINARY.containsKey(operand)) {
                //check errors
                if (processingStack.size() < 2)
                    throw new IllegalFormatException("Binary operator" +
                            " should has two arguments.");

                double second = processingStack.pop();
                double first = processingStack.pop();
                processingStack.push(calculate(operand, first, second));

                //if operation is unary
            } else if (Operation.UNARY.containsKey(operand)) {
                //check errors
                if (processingStack.size() < 1)
                    throw new IllegalFormatException("Unary operator" +
                            "should has one arguments.");

                double first = processingStack.pop();
                processingStack.push(calculate(operand, first));

                //if operand is number
            } else {
                double res;
                try {
                    res = Double.parseDouble(operand);
                } catch (Exception ex) {
                    throw new IllegalFormatException("Wrong number's format or " +
                            "unknown operator: '" + operand + "'.");
                }
                processingStack.push(res);
            }
        }
        if (processingStack.size() < 1)
            return 0;
        return processingStack.pop();
    }

}
