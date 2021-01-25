package com.go2it.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShufflingTest {
    @Test
    public void testShuffle() {
        Comparable[] arr = new Comparable[10];
        arr[0] = 99;
        arr[1] = -2;
        arr[2] = 123;
        arr[3] = 12;
        arr[4] = 38;
        arr[5] = 72;
        arr[6] = 2;
        arr[7] = 0;
        arr[8] = -1;
        arr[9] = -11;
        SelectionSort.sort(arr);

        assertTrue(SortingUtils.isSorted(arr));

        Shuffling.shuffle(arr);
        assertFalse(SortingUtils.isSorted(arr));
    }

}
