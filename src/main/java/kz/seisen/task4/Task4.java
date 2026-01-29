package kz.seisen.task4;

import java.util.Map;

public class Task4 {

    public static void main(String[] args) {

        String template = "Hello ${name}, balance = ${balance:0.00}";

        Map<String, Object> data = Map.of(
                "name", "Dias",
                "balance", 1234.5
        );

        System.out.println(TemplateEngine.render(template, data));
    }
}
