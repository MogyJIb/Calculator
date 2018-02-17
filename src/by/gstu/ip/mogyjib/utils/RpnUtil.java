package by.gstu.ip.mogyjib.utils;

import by.gstu.ip.mogyjib.models.Operation;

import java.util.Stack;

import static by.gstu.ip.mogyjib.utils.StringUtil.CLOSE_BRACKET;
import static by.gstu.ip.mogyjib.utils.StringUtil.OPEN_BRACKET;

/**
 * Created by Zhecka on 16.02.2018.
 */
public class RpnUtil {


    private static Stack<String> operandStack = new Stack<>();
    private static Stack<String> operationStack= new Stack<>();


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

        return resultArr;
    }



    private static void emptyOperationStack(){
        while (!operationStack.isEmpty()) {
            if (operationStack.peek().equals(OPEN_BRACKET)){
                break;
            }
            operandStack.push(operationStack.pop());
        }
    }

}
