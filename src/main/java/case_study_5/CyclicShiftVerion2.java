package case_study_5;

public class CyclicShiftVerion2 {
    public static void main(String[] args) {
        String input = "abcdef";
        String result = "defabc";

        int steps = calculateSteps(input, result);

        System.out.println(steps);


    }

    private static int calculateSteps(String input, String result) {
        if (input.length() <= 1) return 0;
        if (input.length() != result.length()) return -1;

        for (int i = input.length() - 1; i >= 0 ; i--) {
            if ((input.substring(i) + input.substring(0, i)).equals(result)) {
                return input.length() - i;
            }
        }

        return -1;
    }
}
