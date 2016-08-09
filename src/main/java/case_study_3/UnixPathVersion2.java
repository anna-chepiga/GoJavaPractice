package case_study_3;

import java.util.ArrayList;

public class UnixPathVersion2 {
    public static void main(String[] args) {
        String input = "home/../var/./lib/../folder1/./folder2//file.txt";
        String result = simplify(input);

        System.out.println(result);
    }

    private static String simplify(String input) {
        String[] arrayInput = input.split("/");
        ArrayList<String> forResult = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        int i = arrayInput.length - 1;
        boolean doubleDots = false;

        while (i >= 0) {
            if (!arrayInput[i].equals("") && !arrayInput[i].equals(".") && !arrayInput[i].equals("..")) {
                if (!doubleDots) forResult.add(arrayInput[i]);
                doubleDots = false;
            }

            if (arrayInput[i].equals("..")) {
                doubleDots = true;
            }

            i--;
        }

        for (i = forResult.size() - 1; i >= 0; i--) {
            result.append("/").append(forResult.get(i));
        }
        return result.toString();
    }
}