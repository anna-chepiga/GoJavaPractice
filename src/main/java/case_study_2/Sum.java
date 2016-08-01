package case_study_2;

import java.util.ArrayList;

public class Sum {
    public static void main(String[] args) {
        String a = "1100";
        String b = "1111";

        int aInDecimal = convertToDecimal(a);
        int bInDecimal = convertToDecimal(b);

        int sum = aInDecimal + bInDecimal;

        ArrayList<Integer> sumInBinary = convertToBinary(sum);

        String sumBinary = "";

        for (int i = 0; i < sumInBinary.size(); i++) {
            sumBinary += sumInBinary.get(sumInBinary.size() - i - 1);
        }

        System.out.print(a + " + " + b + " = " + sumBinary);
    }

    private static int convertToDecimal(String binary) {
        char[] binaryInChars = binary.toCharArray();
        int power = binaryInChars.length - 1;
        int sum = 0;

        for (char element : binaryInChars) {
            int number = Character.getNumericValue(element);
            int result = (int) (Math.pow(2, power) * number);
            sum += result;
            power--;
        }

        return sum;
    }

    private static ArrayList<Integer> convertToBinary(int inDecimal) {
        int integer;
        int remainder;

        ArrayList<Integer> inBinary = new ArrayList<>();

        do {
            integer = inDecimal / 2;
            remainder = inDecimal % 2;

            inBinary.add(remainder);

            inDecimal = integer;
        } while (integer != 0);
        return inBinary;
    }
}
