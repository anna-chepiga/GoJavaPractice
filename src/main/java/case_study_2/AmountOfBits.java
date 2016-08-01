package case_study_2;

import java.util.ArrayList;

public class AmountOfBits {
    public static void main(String[] args) {
        int inDecimal = 842;

        ArrayList<Integer> inBinary = convertToBinary(inDecimal);

        System.out.println("decimal: " + inDecimal + ", binary: " + inBinary.toString());

        int amountOfBits = countBits(inBinary);

        System.out.println("amount of one-bits in binary is " + amountOfBits);

    }

    private static ArrayList<Integer> convertToBinary(int inDecimal) {
        int integer;
        int remainder;

        ArrayList<Integer> inBinary = new ArrayList<>();

        do {
            integer = inDecimal / 2;
            remainder = inDecimal % 2;

            inBinary.add(0, remainder);

            inDecimal = integer;

        } while (integer != 0);
        return inBinary;
    }

    private static int countBits(ArrayList<Integer> inBinary) {
        int count = 0;
        for (Integer element : inBinary) {
            if (element == 1)
                count++;
        }
        return count;
    }
}
