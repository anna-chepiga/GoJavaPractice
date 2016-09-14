package case_study_1;

import java.util.Arrays;

public class MatrixSnake {
   public static void main(String[] args) {
      int[][] matrix = {
              {1, 2, 3, 4},
              {5, 6, 7, 8},
              {9, 10, 11, 12},
              {13, 14, 15, 16}
      };

      int size = matrix.length; // for square matrix
      int x, y = 0; // coordinates

      int[] array = new int[size * size];
      int k = 0; //index in array

      for (; y < size; y++) {
         for (x = 0; x < size; x++) {
            array[k] = matrix[x][y];
            k++;
         }

         y++;

         if (y == matrix.length) break;

         for (x = size - 1; x >= 0; x--) {
            array[k] = matrix[x][y];
            k++;
         }
      }

      System.out.println(Arrays.toString(array));
   }
}
