package sorting;

public class InsertionSort {
    public static Comparable[] sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (SortingUtils.isLess(arr[j], arr[j])) {
                    SortingUtils.exchange(arr, i, j);
                } else {
                    //everything to the left is already sorted
                    //so this element is already at a proper position if it is higher than the previous one
                    break;
                }
            }

        }
        return arr;
    }

}
