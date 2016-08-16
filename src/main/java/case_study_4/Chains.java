package case_study_4;

public class Chains {
    public static void main(String[] args) {
        int length = 10;

        int amountOfWays = howManyWays(length);

        System.out.println("1 white, 2 yellow, 3 red chains, total length of meters: " + length);
        System.out.println("amount of ways to calculate the length is: " + amountOfWays);
    }

    private static int howManyWays(int length) {
        int white = 1;
        int yellow = 2;
        int red = 3;

        int rest; // what is left
        int count = 0;

        for (int i = 0; i < length; i++) {
            rest = length - i * white;

            if (i == length - 1) count++;

            if (rest >= 2) {
                int sumOn2Level = 0;

                for (int j = 0; sumOn2Level < length; j++) {
                    rest = length - j * yellow - i * white;
                    sumOn2Level = i * white + j * yellow;

                    if (sumOn2Level == length) count++;

                    if (rest >= 3) {
                        int sumOn3Level = 0;

                        for (int k = 0; sumOn3Level < length; k++) {
                            sumOn3Level = i * white + j * yellow + k * red;

                            if (sumOn3Level == length) count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}