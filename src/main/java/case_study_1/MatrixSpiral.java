package case_study_1;

import java.util.Arrays;

public class MatrixSpiral {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        int size = matrix.length; // for square matrix

        int y;
        int cycle;
        int steps;

        if (size % 2 == 0) { steps = size / 2; }
        else { steps = (size / 2) + 1; }

        int array[] = new int[size * size];
        int k = 0;

        for (cycle = 1; cycle <= steps; cycle++) {
            for (y = cycle - 1; y < size - cycle + 1; y++) { // >
                array[k] = matrix[cycle - 1][y];
                k++;
            }
            for (y = cycle; y < size - cycle + 1; y++) { // v
                array[k] = matrix[y][size - cycle];
                k++;
            }
            for (y = size - cycle - 1; y >= cycle - 1; --y) { // <
                array[k] = matrix[size - cycle][y];
                k++;
            }
            for (y = size - cycle - 1; y >= cycle; y--) { // ^
                array[k] = matrix[y][cycle - 1];
                k++;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
