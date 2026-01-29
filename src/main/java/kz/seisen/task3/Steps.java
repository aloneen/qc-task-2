package kz.seisen.task3;

import java.util.function.Function;

public class Steps {

    // trim
    public static Function<String, String> trim() {
        return String::trim;
    }

    // без try/catch
    public static Function<String, Integer> toInt() {
        return Integer::parseInt;
    }
}
