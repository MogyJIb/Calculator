package by.gstu.ip.mogyjib.utils;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Zhecka on 17.02.2018.
 */
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
