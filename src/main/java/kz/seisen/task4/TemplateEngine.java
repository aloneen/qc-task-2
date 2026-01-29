package kz.seisen.task4;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEngine {


    private static final Pattern PLACEHOLDER = Pattern.compile("\\$\\{(\\w+)(?::([^}]+))?}");

    public static String render(String template, Map<String, Object> values) {

        Matcher matcher = PLACEHOLDER.matcher(template);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);
            String format = matcher.group(2);

            Object value = values.get(key);
            String replacement = Formatter.format(value, format);

            matcher.appendReplacement(result, replacement);
        }

        matcher.appendTail(result);
        return result.toString();
    }
}
