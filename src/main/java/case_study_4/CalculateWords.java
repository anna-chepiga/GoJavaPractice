package case_study_4;

public class CalculateWords {
    public static void main(String[] args) {
        String input = "I've got 3 red, 2 black and 1 white kittens";

        int amountOfWords = countWords(input);

        System.out.println(amountOfWords);
    }

    private static int countWords(String input) {
        String[] symbols = input.split(" ");
        int count = 0;

        for (String word : symbols) {
            if (checkWord(word)) count++;
        }
        return count;
    }

    private static boolean checkWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            int codePoint = word.codePointAt(i);

            if (!Character.isAlphabetic(codePoint)) {
                return codePoint == 44 || codePoint == 39;
            }
        }

        return true;
    }
}