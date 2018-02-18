package by.gstu.ip.mogyjib.utils;

import by.gstu.ip.mogyjib.interfaces.StringOperationable;

import java.io.*;


public class TaskUtil {
    private final  boolean append = false;
    private StringOperationable function;

    public TaskUtil(StringOperationable function) {

        this.function = function;
    }

    public StringOperationable getFunction() {
        return function;
    }

    public boolean isAppend() {
        return append;
    }

    public void make(String readFileName, String writeFileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeFileName, append));
             BufferedReader br = new BufferedReader(new FileReader(readFileName)))
        {
            String expression;
            double res;
            while((expression=br.readLine())!=null){
                try {
                    res = function.calculate(expression);
                    bw.write(makeAnswer(expression, res));
                }
                catch (Exception ex){
                    bw.write(ex.getMessage());
                }

                bw.newLine();
            }
        }
    }

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
