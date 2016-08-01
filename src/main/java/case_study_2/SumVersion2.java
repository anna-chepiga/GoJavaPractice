package case_study_2;

public class SumVersion2 {
    public static void main(String[] args) {
        String a = "1100";
        String b = "1111";

        int aInBinary = Integer.parseInt(a, 2);
        int bInBinary = Integer.parseInt(b, 2);

        String result = Integer.toBinaryString(aInBinary + bInBinary);

        System.out.println(result);
    }
}
