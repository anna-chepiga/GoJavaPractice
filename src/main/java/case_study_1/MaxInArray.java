package case_study_1;

import java.util.Arrays;
import java.util.Random;

public class MaxInArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(array));

        int max = array[0];

        for (int element : array) {
            if (element > max) { max = element; }
        }

        System.out.println("maximum is " + max);
    }
}
