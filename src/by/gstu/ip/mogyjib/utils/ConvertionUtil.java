package by.gstu.ip.mogyjib.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class ConvertionUtil {
    public static double toRadians(double degrees){
        return degrees*Math.PI/180;
    }

    public static String parseDouble(double value){
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        numberFormat.setMaximumFractionDigits(5);
        numberFormat.setGroupingUsed(false);
        return numberFormat.format(value);
    }
}
