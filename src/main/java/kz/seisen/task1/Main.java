package kz.seisen.task1;

import java.util.Scanner;

public class Main {

    public static Object parseLine(String line) {
        String input = line.trim();

        for (ParserType type : ParserType.values()) {
            ParseResult result = type.parse(input);
            if (result.isSuccess()) {
                return result.get();
            }
        }

        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            Object value = parseLine(scanner.nextLine());

            System.out.println("Type: " + value.getClass().getSimpleName());
        }
    }
}
