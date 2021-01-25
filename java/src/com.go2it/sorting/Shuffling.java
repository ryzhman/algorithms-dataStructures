package com.go2it.sorting;

import java.util.Random;

public class Shuffling {

    public static Comparable[] shuffle(Comparable[] arr) {
        Random random = new Random(arr.length -1);
        for (int i = 0; i < arr.length; i++) {
            SortingUtils.exchange(arr, random.nextInt(10), i);
        }

        return arr;
    }
}
