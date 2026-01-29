package kz.seisen.task1;

public class ParseResult {

    private final Object value;

    private ParseResult(Object value) {
        this.value = value;
    }

    public static ParseResult success(Object value) {
        return new ParseResult(value);
    }

    public static ParseResult failure() {
        return new ParseResult(null);
    }

    public boolean isSuccess() {
        return value != null;
    }

    public Object get() {
        return value;
    }
}
