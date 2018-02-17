package by.gstu.ip.mogyjib.utils;

import by.gstu.ip.mogyjib.interfaces.StringOperationable;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Zhecka on 17.02.2018.
 */
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
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(writeFileName,append));
                BufferedReader br = new BufferedReader(new FileReader(readFileName)))
        {
            StringBuilder text = new StringBuilder();
            String expression = "";
            double res = 0;
            while((expression=br.readLine())!=null){
                try {
                    res = function.calculate(expression);

                    text.append(expression);
                    text.append("=");
                    text.append(ConvertionUtil.parseDouble(res));

                    bw.write(text.toString());
                }
                catch (ArithmeticException ex){
                    bw.write("Division by zero");
                }
                catch (Exception ex){
                    bw.write(ex.getMessage());
                }
                bw.newLine();
                text.delete(0,text.length());
            }
        }
        catch(IOException ex){
            throw ex;
        }
    }
}
