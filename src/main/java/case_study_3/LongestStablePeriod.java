package case_study_3;

import java.util.ArrayList;
import java.util.Collections;

public class LongestStablePeriod {
    public static void main(String[] args) {
        int[] period = {
                1_000_000_000,
                1_000_200_200, //1
                1_000_200_201, //2
                1_000_200_200, //3
                1_000_200_201, //4
                1_000_200_201, //5
                1_000_200_200, //6
                1_000_200_200, //7
                1_000_200_300,
                1_000_200_400, //1
                1_000_200_401, //2
                1_000_200_600,
                1_000_200_501, //1
                1_000_200_501, //2
                1_000_200_502, //3
                1_000_200_502, //4
                1_000_200_501, //5
                1_000_200_601,
                1_000_200_801,
        };

        int maxStablePeriod = getMaxStablePeriod(period);

        System.out.println("the longest stable period was " + maxStablePeriod + " months");
    }

    private static int getMaxStablePeriod(int[] period) {
        int count = 1;

        ArrayList<Integer> stablePeriods = new ArrayList<>();

        for (int i = 0; i < period.length - 1; i++) {
            if (period[i] - period[i + 1] == 1 || period[i] - period[i + 1] == -1 || period[i] == period[i + 1]) {
                count++;
            } else {
                stablePeriods.add(count);
                count = 1;
            }
        }

        Collections.sort(stablePeriods);

        return stablePeriods.get(stablePeriods.size() - 1);
    }
}