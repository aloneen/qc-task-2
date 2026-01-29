package kz.seisen.task1;

import java.time.LocalDate;
import java.util.function.Function;

public enum ParserType {
    INT(Integer::parseInt),
    DOUBLE(Double::parseDouble),
    BOOLEAN(ParserType::parseBoolean),
    LOCALDATE(LocalDate::parse),
    STRING(s -> s);


    private final Function<String, Object> parser;

    ParserType(Function<String, Object> parser) {
        this.parser = parser;
    }

    public ParseResult parse(String value) {
        try {
            return ParseResult.success(parser.apply(value));
        } catch (Exception e) {
            return ParseResult.failure();
        }
    }

    private static Boolean parseBoolean(String s) {
        String value = s.toLowerCase();

        if (value.equals("true")) return true;
        if (value.equals("false")) return false;

        throw new IllegalArgumentException();
    }
}
