package kz.seisen.task3;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> data = List.of("32  ", "2322", "  ", "dias", " 67", " 1 ", "43");

        int sum = data.stream()
                .map(Steps.trim())               // Function
                .filter(Filters.notEmpty())      // Predicate
                .filter(Filters.isNumber())      // Predicate (защита от ошибок)
                .map(Steps.toInt())              // Function
                .filter(Filters.even())          // Predicate
                .mapToInt(Integer::intValue)     // агрегация
                .sum();

        System.out.println(sum); // 152
    }
}
