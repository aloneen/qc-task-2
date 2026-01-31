package kz.seisen.task10;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {

        // yes "some long line of text for testing" | head -n 50000000 > bigfile.txt
        Path file = Path.of("/Users/diasseisenbek/Desktop/qazcode/tests/bigfile.txt");

        Result result = FileProcessor.process(file);

        System.out.println("Total lines: " + result.lines());
        System.out.println("Total characters: " + result.characters());
        System.out.println("Max line length: " + result.maxLineLength());
        System.out.println("Average line length: " + result.averageLineLength());
        System.out.println("Execution time: " + result.durationMs());
    }
}
