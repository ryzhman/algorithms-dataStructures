package com.go2it.sorting;

public class InsertionSort {
    public static Comparable[] sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentElem = i;
            int j = currentElem -1;
            while (j > -1) {
                if (SortingUtils.isLess(arr[currentElem], arr[j])) {
                    SortingUtils.exchange(arr, currentElem, j);
                } else {
                    //everything to the left is already sorted
                    //so this element is already at a proper position if it is higher than the previous one
                    break;
                }
                j--;
                currentElem--;
            }

        }
        return arr;
    }

}
