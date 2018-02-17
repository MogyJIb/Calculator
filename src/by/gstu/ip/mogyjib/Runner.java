package by.gstu.ip.mogyjib;


import by.gstu.ip.mogyjib.exceptions.IllegalFormatException;
import by.gstu.ip.mogyjib.models.Calculator;
import by.gstu.ip.mogyjib.utils.RpnUtil;
import by.gstu.ip.mogyjib.utils.StringUtil;

import java.util.Arrays;
import java.util.Calendar;


public class Runner {
    public static void main(String[] args){
        String expression = "(4-2)/(( sin(30)+1 )*2) ";

        expression = StringUtil.processUnMinus(expression);

        String[] operands = StringUtil.splitToOperands(expression);
        String[] operandsRpn = RpnUtil.makeRpn(operands);

        Arrays.asList(operands).forEach(op -> System.out.print(op+" "));
        System.out.print("\n");
        Arrays.asList(operandsRpn).forEach(op -> System.out.print(op+" "));

        double res = 0;
        try {
            res = Calculator.calculateComplexExpression(expression);
            System.out.println("\n"+expression+" = "+res+"\n");
        }
        catch (IllegalFormatException ex){
            System.out.println("\n"+ex.getMessage()+"\n");
        }

    }


}
