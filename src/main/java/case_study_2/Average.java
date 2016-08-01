package case_study_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int a;
        int b;

        System.out.println("Please enter two integer numbers:");

        try {
            Scanner sc = new Scanner(System.in);

            a = sc.nextInt();
            b = sc.nextInt();

            double c = average(a, b);
            System.out.println("Average between " + a + " and " + b + " is " + c);
        } catch (InputMismatchException e) {
            System.out.println("Please make sure you enter integer numbers");
        }
    }

    private static double average(int a, int b) {
        return (a + b) / 2;
    }
}
