package com.go2it.tasks;

/**
 * Check if two arrays are exact permutations - same values in a different order
 */
public class ArraysPermutation {

    public static boolean arePermutations(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        sortByInsertion(arr1);
        sortByInsertion(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void sortBySelection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = min; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    private static void sortByInsertion(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                continue;
            }
            int current = i;
            for (int j = current-1; j >= 0; j--) {
                if (arr[current] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[current];
                    arr[current] = temp;
                    current = j;
                } else {
                    break;
                }
            }
        }
    }

}
