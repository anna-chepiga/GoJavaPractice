package case_study_2;

import java.util.ArrayList;

public class HexatridecimalNotation {
    private static final ArrayList<Character> ALPHABET = new ArrayList<>();

    static {
        for (char c = '0'; c <= '9'; c++) {
            ALPHABET.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            ALPHABET.add(c);
        }
    }

    private static final int BASE = 36;

    public static void main(String[] args) {
        String firstNumberIn36 = "UU71O";
        int firstNumberIn10 = convertTo10(firstNumberIn36);
        System.out.println("number " + firstNumberIn36 + " in hexatridecimal notation is " + firstNumberIn10 + " in decimal notation");

        String secondNumberIn36 = "13N0";
        int secondNumberIn10 = convertTo10(secondNumberIn36);
        System.out.println("number " + secondNumberIn36 + " in hexatridecimal notation is " + secondNumberIn10 + " in decimal notation");

        int sum = firstNumberIn10 + secondNumberIn10;
        System.out.println("their sum in decimal notation is " + sum);

        ArrayList<Character> sumIn36 = convertTo36(sum);
        System.out.print("their sum in hexatridecimal notation is " + sumIn36.toString());
    }

    private static ArrayList<Character> convertTo36(int sum) {
        int integer;
        int remainder;

        ArrayList<Character> sumIn36 = new ArrayList<>();

        do {
            integer = sum / BASE;
            remainder = sum % BASE;

            char include = ALPHABET.get(remainder);
            sumIn36.add(0, include);

            sum = integer;
        } while (integer != 0);
        return sumIn36;
    }

    private static int convertTo10(String numberIn36) {
        char[] numberInChars = numberIn36.toCharArray();
        int size = numberInChars.length;
        int numberIn10 = 0;

        for (int i = 0; i < numberInChars.length; i++) {
            char element = numberInChars[size - 1];
            int index = ALPHABET.indexOf(element);
            int inAlphabet = (int) Math.pow(BASE, i) * index;
            numberIn10 = numberIn10 + inAlphabet;
            size--;
        }
        return numberIn10;
    }
}
