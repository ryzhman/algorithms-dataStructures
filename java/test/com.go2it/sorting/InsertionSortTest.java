package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertionSortTest {

    @Test
    public void testSort() {
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
        InsertionSort.sort(arr);

        assertTrue(SortingUtils.isSorted(arr));
    }
}
