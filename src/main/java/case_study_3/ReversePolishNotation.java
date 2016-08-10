package case_study_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {
    public static void main(String[] args) {
        //три варинта строки на пробу - работают все
        // 1) result 6; 2) result 19; 3) result 45

        //String input = "8 2 5 * + 1 3 2 * + 4 - /";
        //String input = "7 5 2 - 4 * +";
        String input = "12 15 + 3 / 42 2 - 8 / *";

        String result = calculate(input);

        System.out.println("The result of calculating [" + input + "] is " + result);
    }

    private static String calculate(String input) {
        String[] inputNumbers = input.split(" ");
        Deque<Integer> result = new ArrayDeque<>();

        int forResult = 0;

        for (String number : inputNumbers) {
            if (!number.equals("+") && !number.equals("-")
                    && !number.equals("*") && !number.equals("/")) {
                result.push(Integer.parseInt(number));
            } else {
                int a = result.pop();
                int b = result.pop();

                if (number.equals("+")) forResult = a + b;
                if (number.equals("-")) forResult = b - a;
                if (number.equals("*")) forResult = a * b;
                if (number.equals("/")) forResult = b / a;

                result.push(forResult);
            }
        }

        return result.toString();
    }
}