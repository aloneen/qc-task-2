package kz.seisen.task10;

public record Result(
        long lines,
        long characters,
        long maxLineLength,
        double averageLineLength,
        long durationMs
) {
}
