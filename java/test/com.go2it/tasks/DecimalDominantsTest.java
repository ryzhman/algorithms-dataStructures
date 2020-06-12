package tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DecimalDominantsTest {
    private final int[] ARR = {1, 1, 2, 4, 5, 6, 2, 1, 3, 4, 5, 8, 10, -1, 0, 0, 0, 0, 1, 5};
    private final Comparable[] ARR_COMP = {1, 1, 2, 4, 5, 6, 2, 1, 3, 4, 5, 8, 10, -1, 0, 0, 0, 0, 1, 5};


    @Test
    public void findEntriesOccurringMoreThanKTimesTest() {
        int[] result = DecimalDominants.findEntriesOccurringMoreThanKTimes(ARR);
        assertTrue(Arrays.equals(new int[]{0, 1, 2, 4, 5}, result));
    }


    @Test
    public void findEntriesOccurringMoreThanKTimesMergeSortTest() {
        Comparable[] result = DecimalDominants.findEntriesOccurringMoreThanKTimesMergeSort(ARR_COMP);
        assertTrue(Arrays.equals(new Comparable[]{0, 1, 2, 4, 5}, result));
    }




}
