package kz.seisen.task4;

import java.text.DecimalFormat;

public class Formatter {

    public static String format(Object value, String format) {
        if (value == null) {
            return "";
        }

        if (format == null) {
            return value.toString();
        }

        if (value instanceof Number) {
            return new DecimalFormat(format).format(value);
        }

        return value.toString();
    }
}
