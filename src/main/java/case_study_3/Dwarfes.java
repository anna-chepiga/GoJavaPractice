package case_study_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dwarfes {
    public static void main(String[] args) {
        int[] dwarfs = {5, 7, 6, 9, 4};
        int[] portions = {8, 5, 6, 2, 3};

        int[] result = findSequence(dwarfs, portions);

        System.out.println(Arrays.toString(result));
    }

    private static int[] findSequence(int[] dwarfs, int[] portions) {
        int amountOfDwarfs = dwarfs.length;

        ArrayList<Integer> descendingDwarfs = new ArrayList<>();
        for (int dwarf : dwarfs) { descendingDwarfs.add(dwarf); }

        ArrayList<Integer> descendingPortions = new ArrayList<>();
        for (int portion : portions) { descendingPortions.add(portion); }

        Collections.sort(descendingDwarfs, Collections.reverseOrder());
        Collections.sort(descendingPortions, Collections.reverseOrder());

        int[] result = new int[amountOfDwarfs];

        for (int i = 0; i < amountOfDwarfs; i++) {
            int biggestDwarf = descendingDwarfs.get(i);
            int biggestPortion = descendingPortions.get(i);
            int dwarfIndex = 0;
            int portionIndex = 0;

            for (int j = 0, k = 0; j < amountOfDwarfs && k < amountOfDwarfs; j++, k++) {
                if (biggestDwarf == dwarfs[j]) dwarfIndex = j;
                if (biggestPortion == portions[k]) portionIndex = k;
            }

            result[dwarfIndex] = portionIndex;
        }
        return result;
    }
}
