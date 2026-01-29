package kz.seisen.task3;

import java.util.function.Predicate;

public class Filters {

    public static Predicate<String> notEmpty() {
        return s -> !s.isEmpty();
    }


    public static Predicate<String> isNumber() {
        return s -> s.matches("-?\\d+");
    }

    public static Predicate<Integer> even() {
        return n -> n % 2 == 0;
    }
}
