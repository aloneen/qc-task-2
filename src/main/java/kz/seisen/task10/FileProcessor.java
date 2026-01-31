package kz.seisen.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    private static final String UTF8_BOM = "\uFEFF";

    public static Result process(Path file) throws IOException {

        long lines = 0;
        long chars = 0;
        long maxLen = 0;

        long start = System.currentTimeMillis();

        try (BufferedReader r = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            String line;
            boolean first = true;

            while ((line = r.readLine()) != null) {

                if (first && line.startsWith(UTF8_BOM)) {
                    line = line.substring(1);
                }
                first = false;

                if (line.isBlank() || line.startsWith("#")) continue;

                int len = line.length();
                lines++;
                chars += len;
                if (len > maxLen) maxLen = len;
            }
        }

        long timeMs = System.currentTimeMillis() - start;
        double avg = lines == 0 ? 0 : (double) chars / lines;

        return new Result(lines, chars, maxLen, avg, timeMs);
    }
}
