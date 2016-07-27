package case_study_1;

public class Sum {
    public static void main(String[] args) {
        int number = 760294;
        int x = number;
        int sum = 0;

        while (x != 0 ){
            sum = sum + x%10;
            x = x/10;
        }

        System.out.println("the sum of digits in number " + number + " is " + sum);
    }
}
