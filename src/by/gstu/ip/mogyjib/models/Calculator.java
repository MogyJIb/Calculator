package by.gstu.ip.mogyjib.models;


import by.gstu.ip.mogyjib.exceptions.IllegalFormatException;
import by.gstu.ip.mogyjib.utils.RpnUtil;
import by.gstu.ip.mogyjib.utils.StringUtil;

import java.util.Stack;

public class Calculator {
    public static double calculate(String operation,double first,double second){
        return Operation.BINARY.get(operation).calculate(first,second);
    }

    public static double calculate(String operation,double first){
        return Operation.UNARY.get(operation).calculate(first);
    }


    public static double calculateSimpleExpression(String expression)
            throws IllegalFormatException {
        if (expression.isEmpty())
            throw new IllegalFormatException("Empty line.");

        expression = StringUtil.processUnMinus(expression);

        String[] operands = StringUtil.splitToOperands(expression);
        if (operands.length < 3)
            throw new IllegalFormatException("Binary operator should has two arguments.");

        double first=0,second =0;
        String operation = operands[1];
        try {
            first = Double.parseDouble(operands[0]);
            second = Double.parseDouble(operands[2]);
        }catch (Exception ex){
            throw new IllegalFormatException("Wrong number's format: '" + first + "', '" + second + "'.");
        }

        return calculate(operation,first,second);
    }

    public static double calculateComplexExpression(String expression)
            throws IllegalFormatException {
        if (expression.isEmpty())
            throw new IllegalFormatException("Empty line.");

        expression = StringUtil.processUnMinus(expression);

        String[] operands = StringUtil.splitToOperands(expression);
        String[] operandsRpn = RpnUtil.makeRpn(operands);

        return processRpnExpression(operandsRpn);
    }


    public static double processRpnExpression(String[] operands)
            throws IllegalFormatException {
        if (operands == null || operands.length == 0)
            throw new IllegalFormatException("Inputted string is empty.");

        Stack<Double> processingStack = new Stack<>();
        for (String operand : operands) {
            if (Operation.BINARY.containsKey(operand)) {
                //check errors
                if (processingStack.size() < 2)
                    throw new IllegalFormatException("Binary operator should has two arguments.");

                double second = processingStack.pop();
                double first = processingStack.pop();
                processingStack.push(calculate(operand, first, second));

            } else if (Operation.UNARY.containsKey(operand)) {
                //check errors
                if (processingStack.size() < 1)
                    throw new IllegalFormatException("Unary operator should has one arguments.");

                double first = processingStack.pop();
                processingStack.push(calculate(operand, first));

            } else {
                double res;
                try {
                    res = Double.parseDouble(operand);
                } catch (Exception ex) {
                    throw new IllegalFormatException("Wrong number's format or unknown operator: '" + operand + "'.");
                }
                processingStack.push(res);
            }
        }
        if (processingStack.size() < 1)
            return 0;
        return processingStack.pop();
    }

}
