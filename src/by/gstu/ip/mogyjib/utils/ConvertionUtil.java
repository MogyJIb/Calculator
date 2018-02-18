package by.gstu.ip.mogyjib.utils;

import java.text.NumberFormat;
import java.util.Locale;


/**
 * Utility which contain some static
 * methods to convert.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class ConvertionUtil {
    /**
     * Parse degrees to radians.
     *
     * @param degrees number of degrees
     * @return double value - number of radians
     */
    public static double toRadians(double degrees){
        return degrees*Math.PI/180;
    }

    /**
     * Parse double to string with 5
     * max fraction digits.
     *
     * @param value double number
     * @return string value - converted number
     */
    public static String parseDouble(double value){
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        numberFormat.setMaximumFractionDigits(5);
        numberFormat.setGroupingUsed(false);
        return numberFormat.format(value);
    }
}
