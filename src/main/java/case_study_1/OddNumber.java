package case_study_1;

import java.util.Arrays;
import java.util.Random;

public class OddNumber {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(array));

        int index = findOdd(array);

        if (index >= 0) {
            System.out.println("first odd number: " + array[index] + ", position: " + index);
        } else System.out.println(index);

    }

    private static int findOdd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                return i;
            }
        }
        return -1;
    }
}

