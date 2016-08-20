package case_study_4;

public class StringToNumbers {
    public static void main(String[] args) {
        String sFloat = "3.4E+3F";
        String s16 = "0x55";
        String sDoubleExp = "1.7e+5";
        String sDoubleDot = ".66";
        String sInteger = "011";
        String sLong = "6688L";
        String sBinary = "0b110";

        Double d = convert(sBinary);

        System.out.println(d);
    }

    private static Double convert(String s) {
        if (check16(s)) s = convertFrom16(s);
        if (checkBinary(s)) s = convertFromBinary(s);
        if (checkLong(s)) s = convertFromLong(s);

        Double d;
        try {
            d = Double.parseDouble(s);
        } catch (Exception e) {
            return null;
        }
        return d;
    }

    private static boolean check16(String s) {
        char first = s.charAt(0);
        char second = s.charAt(1);
        return first == '0' && (second == 'x' || second == 'X');
    }

    private static String convertFrom16(String s) {
        String converted;
        converted = String.copyValueOf(s.toCharArray(), 2, s.length() - 2);

        int i = Integer.parseInt(converted, 16);

        return String.valueOf(i);
    }

    private static boolean checkBinary(String s) {
        char first = s.charAt(0);
        char second = s.charAt(1);

        return first == '0' && (second == 'b' || second == 'B');
    }

    private static String convertFromBinary(String s) {
        String converted;
        converted = String.copyValueOf(s.toCharArray(), 2, s.length() - 2);

        int i = Integer.parseInt(converted, 2);

        return String.valueOf(i);
    }

    private static boolean checkLong(String s) {
        char c = s.charAt(s.length() - 1);
        return c == 'L' || c == 'l';
    }

    private static String convertFromLong(String s) {
        String converted = s;
        converted = String.copyValueOf(s.toCharArray(), 0, s.length() - 1);

        return converted;
    }
}