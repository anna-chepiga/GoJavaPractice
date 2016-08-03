package case_study_2;

public class AmountOfBits {
    public static void main(String[] args) {
        int inDecimal = 842;

        String inBinary = convertToBinary(inDecimal);

        System.out.println("decimal: " + inDecimal + ", binary: " + inBinary);

        int amountOfBits = countBits(inBinary);

        System.out.println("amount of one-bits in binary is " + amountOfBits);

    }

    private static String convertToBinary(int inDecimal) {
        int integer;
        int remainder;

        StringBuilder sb = new StringBuilder();

        do {
            integer = inDecimal / 2;
            remainder = inDecimal % 2;

            sb.append(remainder);

            inDecimal = integer;

        } while (integer != 0);
        return sb.reverse().toString();
    }

    private static int countBits(String inBinary) {
        char[] bits = inBinary.toCharArray();
        int count = 0;
        for (Character element : bits) {
            if (element == '1')
                count++;
        }
        return count;
    }
}
