package case_study_2;

public class ReplaceBit {
    public static void main(String[] args) {
        int decimal = 444;
        String binary = Integer.toBinaryString(decimal);
        int bitToReplace = 5; // should be not bigger than binary.length - 1

        System.out.println("the decimal number " + decimal + " is binary " + binary);

        String binaryAfterReplace = replaceBit(binary, bitToReplace);

        if (binaryAfterReplace.equals(binary)) {
            System.out.println("the mentioned bit is zero, nothing to replace");
        } else {
            int decimalAfterReplace = convertToDecimal(binaryAfterReplace);
            System.out.println("the binary number after replace is " + binaryAfterReplace +
                    ", in decimal it's " + decimalAfterReplace);

        }
    }

    private static String replaceBit(String inBinary, int bitToReplace) {
        char[] bits = inBinary.toCharArray();

        if (bitToReplace >= 1 && bitToReplace < inBinary.length()) {
            bits[bitToReplace - 1] = '0';
        }

        inBinary = String.valueOf(bits);

        return inBinary;
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
