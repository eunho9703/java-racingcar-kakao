package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final int CUSTOM_DELIMITER_GROUPINDEX = 1;
    private static final int TEXT_GROUPINDEX = 2;

    private static Matcher matcher = null;

    public static int sumProcess(String[] strList) {
        return sum(toInts(strList));
    }

    public static String[] split(String text) {
        matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (text == null || text.isEmpty()) {
            return new String[]{"0"};
        }

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUPINDEX) + "|,|;";
            return matcher.group(TEXT_GROUPINDEX).split(customDelimiter);
        }

        return text.split(",|;");
    }

    private static List<Integer> toInts(String[] values) {
        return Arrays.stream(values)
                .map(Integer::parseUnsignedInt)
                .collect(Collectors.toList());
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
