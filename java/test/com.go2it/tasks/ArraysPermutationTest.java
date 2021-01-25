package com.go2it.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraysPermutationTest {

    @Test
    public void testArePermutations() {
        int[] arr1 = {5,1,99,-1,9,1,7};
        int[] arr2 = {5,99,1,7,9,-1,1};
        assertTrue(ArraysPermutation.arePermutations(arr1, arr2));
    }
}
