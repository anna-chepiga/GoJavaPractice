package case_study_2;

public class ReplaceBitVersion2 {
    public static void main(String[] args) {
        int decimal = 6;
        String binary = Integer.toBinaryString(decimal);
        int bitToReplace = 2; // should be not bigger than binary.length - 1

        System.out.println("the decimal number " + decimal + " is binary " + binary);

        StringBuilder builder = new StringBuilder(binary);

        builder.setCharAt(bitToReplace - 1, '0');

        String binaryAfterReplace = builder.toString();

        if (binaryAfterReplace.equals(String.valueOf(binary))) {
            System.out.println("the mentioned bit is zero, nothing to replace");
        } else {
            int decimalAfterReplace = convertToDecimal(binaryAfterReplace);
            System.out.println("the binary number after replace is " + binaryAfterReplace +
                    ", in decimal it's " + decimalAfterReplace);

        }
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
