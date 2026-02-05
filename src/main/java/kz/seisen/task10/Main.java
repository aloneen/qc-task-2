package kz.seisen.task10;

import io.github.cdimascio.dotenv.Dotenv;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {

        // yes "some long line of text for testing" | head -n 50000000 > bigfile.txt

        Dotenv dotenv = Dotenv.load();
        String filePath = dotenv.get("INPUT_FILE");

        if (filePath == null || filePath.isBlank()) {
            System.out.println("INPUT_FILE env variable is not set");
            return;
        }

        Path file = Path.of(filePath);

        Result result = FileProcessor.process(file);

        System.out.println("Total lines: " + result.lines());
        System.out.println("Total characters: " + result.characters());
        System.out.println("Max line length: " + result.maxLineLength());
        System.out.println("Average line length: " + result.averageLineLength());
        System.out.println("Execution time: " + result.durationMs());
    }
}
