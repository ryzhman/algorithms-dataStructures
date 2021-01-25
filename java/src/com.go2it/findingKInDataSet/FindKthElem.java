package com.go2it.findingKInDataSet;

import com.go2it.sorting.SortingUtils;

public class FindKthElem {

    /**
     * Finding the k-th smallest elem in the array using the quick select
     * O(log(n)) --> O(n)
     *
     * @param arr
     * @param indexOfInterest
     * @param lowIndex
     * @param highIndex
     * @param pivotElemIndex
     * @return
     */
    public static Comparable findKthSmallestElem(Comparable[] arr, int indexOfInterest, int lowIndex, int highIndex, int pivotElemIndex) {
        //three-partition the array using the pivot elem
        int partitionElemIndex = partition(arr, lowIndex, highIndex, pivotElemIndex);
        if (partitionElemIndex == indexOfInterest) {
            return arr[partitionElemIndex];
        }
        if (indexOfInterest > partitionElemIndex) {
            //move to the right
            //partitionElemIndex + 1 because the current value of partitionElemIndex is already on the correct spot
            return findKthSmallestElem(arr, indexOfInterest, partitionElemIndex + 1, arr.length - 1, partitionElemIndex + 1);
        } else {
            //move to the left
            return findKthSmallestElem(arr, indexOfInterest, 1, partitionElemIndex + 1, 0);
        }
    }

    private static int partition(Comparable[] arr, int lowIndex, int highIndex, int pivotElemIndex) {
        while (lowIndex < highIndex) {
            if (SortingUtils.isLess(arr[lowIndex], arr[pivotElemIndex])) {
                //move to the left side
                SortingUtils.exchange(arr, lowIndex++, pivotElemIndex++);
            } else if (SortingUtils.isLess(arr[highIndex], arr[lowIndex])) {
                //move to the right
                SortingUtils.exchange(arr, highIndex--, lowIndex);
            } else {
                //duplicate elem or just skil it
                lowIndex++;
            }
        }
        return pivotElemIndex;
    }

}
