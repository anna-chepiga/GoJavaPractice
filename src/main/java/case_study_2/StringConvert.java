package case_study_2;

import java.util.HashMap;
import java.util.Map;

public class StringConvert {
    private static final Map<Character, Integer> CONVERTER = new HashMap<>();

    static {
        int i; char c;
        for (i = 0, c = 'a'; i <=9 && c <= 'j'; i++, c++) {
            CONVERTER.put(c, i);
        }
    }

    public static void main(String[] args) {
        String input = "ddjb";

        int convertedInput = convertToNumbers(input);

        System.out.println("string \"" + input + "\" is "  + convertedInput + " in numbers");

    }

    private static int convertToNumbers(String input) {
        char[] inputInChars = input.toCharArray();
        String inputInNumbers = "";
        StringBuilder builder = new StringBuilder();

        for (char index : inputInChars) {
            int number = CONVERTER.get(index);
            String s = String.valueOf(number);

            builder.append(s);

            inputInNumbers = builder.toString();
        }

        return Integer.parseInt(inputInNumbers);
    }
}
