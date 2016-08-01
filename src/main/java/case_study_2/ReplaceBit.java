package case_study_2;

public class ReplaceBit {
    public static void main(String[] args) {
        int decimal = 8;
        String binary = Integer.toBinaryString(decimal);
        int bitToReplace = 2; // should be not bigger than binary.length - 1

        System.out.println("the decimal number " + decimal + " is binary " + binary);

        String binaryAfterReplace = replaceBit(binary, bitToReplace);

        if (binaryAfterReplace.equals(String.valueOf(binary))) {
            System.out.println("the mentioned bit is zero, nothing to replace");
        } else {
            int decimalAfterReplace = convertToDecimal(binaryAfterReplace);
            System.out.println("the binary number after replace is " + binaryAfterReplace +
                    ", in decimal it's " + decimalAfterReplace);

        }
    }

    private static String replaceBit(String inBinary, int bitToReplace) {
        String afterReplace = "";

        for (int i = 0; i < inBinary.length(); i++) {
            char c = inBinary.charAt(i);
            int j = Character.getNumericValue(c);

            if (i == (bitToReplace - 1) & j == 1) {
                j = 0;
            }

            afterReplace += j;
        }
        return afterReplace;
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
}
