package case_study_5;

public class CyclicShift {
    public static void main(String[] args) {
        String begin = "abcdef";
        String end = "defabc";

        int steps1 = calcSteps(begin, end);

        System.out.println(steps1);
    }

    private static int calcSteps(String begin, String end) {
        int offset = begin.length();
        int toDelete = offset - 1;

        int steps = 0;

        StringBuilder sb = new StringBuilder(begin);
        int size = sb.length();

        do {
            sb.insert(0, begin, toDelete, offset);
            sb.deleteCharAt(size);

            steps++;

            toDelete--;
            offset--;

            if (toDelete < 0) return -1;
        } while (!sb.toString().equals(end));

        return steps;
    }
}