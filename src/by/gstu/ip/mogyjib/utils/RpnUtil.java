package by.gstu.ip.mogyjib.utils;

import by.gstu.ip.mogyjib.models.Operation;

import java.util.Stack;

import static by.gstu.ip.mogyjib.utils.StringUtil.CLOSE_BRACKET;
import static by.gstu.ip.mogyjib.utils.StringUtil.OPEN_BRACKET;


/**
 * Utility to parse expression from
 * infix form to postfix - rpn.
 * <p>
 * Reverse poland notation - RPN, form
 * of writing of expression where operation
 * stay after operands '2 3 +', while infix
 * notation '2 + 3'.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class RpnUtil {
    private static Stack<String> operandStack = new Stack<>();
    private static Stack<String> operationStack= new Stack<>();

    /**
     * Method which make postfix form from infix,
     * get as parameter array of operands.
     *
     * @param operands array of operands in infix form
     *                 like ['1','+','2']
     * @return array of operands in postfix\rpn form
     * like ['1','2','+']
     */
    public static String[] makeRpn(String[] operands) {

        //go from item to item and make operand stack
        for (String operand : operands) {

            //if this operand is close bracket
            if (operand.equals(CLOSE_BRACKET)) {
                emptyOperationStack();

                if (!operationStack.isEmpty()
                        && operationStack.peek().equals(OPEN_BRACKET))
                    operationStack.pop();
            } else {
                if (Operation.isOperation(operand)) {
                    if (!operationStack.isEmpty()
                            && (Operation.compare(operand, operationStack.peek()) < 0))
                        emptyOperationStack();
                    operationStack.push(operand);
                } else if (operand.equals(OPEN_BRACKET))
                    operationStack.push(operand);
                else
                    operandStack.push(operand);
            }
        }

        //push all operands from operation stack to operand stack while stack is empty
        emptyOperationStack();

        String[] resultArr = new String[operandStack.size()];
        operandStack.toArray(resultArr);

        free();

        return resultArr;
    }


    /**
     * Method which put all operands from
     * operation stack to operand stack while
     * stack isn't empty or before open bracket.
     */
    private static void emptyOperationStack(){
        while (!operationStack.isEmpty()) {
            if (operationStack.peek().equals(OPEN_BRACKET)){
                break;
            }
            operandStack.push(operationStack.pop());
        }
    }


    /**
     * Clear all static data stack.
     */
    private static void free() {
        operandStack.clear();
        operationStack.clear();
    }

}
