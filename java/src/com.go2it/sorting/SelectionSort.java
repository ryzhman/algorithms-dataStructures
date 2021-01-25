package com.go2it.sorting;

/**
 * select an element (i) and find the smallest element and swap them
 * O(N^2/2)
 */
public class SelectionSort {

    public static Comparable[] sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minElemIndex = i;
            for (int j = minElemIndex + 1; j < arr.length; j++) {
                if (SortingUtils.isLess(arr[j], arr[minElemIndex])) {
                    minElemIndex = j;
                }
            }
            SortingUtils.exchange(arr, i, minElemIndex);

        }
        return arr;
    }
}
