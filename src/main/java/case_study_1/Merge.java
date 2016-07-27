package case_study_1;

public class Merge {
    public static void main(String[] args) {
        char[] array = {'1', '2', '3', '4', '5'};

        for (char element : array) {
            int i = Character.getNumericValue(element);
            System.out.print(i);
        }
    }
}
