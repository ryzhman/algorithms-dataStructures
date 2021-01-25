package com.go2it.tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DutchFlagTest {
    private String[] arr = {"B", "R", "R", "B", "W", "R", "B", "W", "W"};
    private String[] arr2 = {"B", "R", "R", "B", "W", "R", "W", "W", "B"};

    @Test
    public void testFormTheDutchFlagViaNumbers() {
        DutchFlag.formTheDutchFlagViaNumbers(arr);
        assertTrue(Arrays.equals(new String[]{"B", "B", "B", "R", "R", "R", "W", "W", "W"}, arr));
        DutchFlag.formTheDutchFlagViaNumbers(arr2);
        assertTrue(Arrays.equals(new String[]{"B", "B", "B", "R", "R", "R", "W", "W", "W"}, arr2));
    }

    @Test
    public void testFormTheDutchFlag() {
        DutchFlag.formTheDutchFlag(arr);
        assertTrue(Arrays.equals(new String[]{"B", "B", "B", "R", "R", "R", "W", "W", "W"}, arr));
        DutchFlag.formTheDutchFlagViaNumbers(arr2);
        assertTrue(Arrays.equals(new String[]{"B", "B", "B", "R", "R", "R", "W", "W", "W"}, arr2));
    }

    @Test
    public void testFormTheDutchFlagThreeWayPartitioning() {
        DutchFlag.formTheDutchFlagThreeWayPartitioning(arr);
        assertTrue(Arrays.equals(new String[]{"B", "B", "B", "R", "R", "R", "W", "W", "W"}, arr));
        DutchFlag.formTheDutchFlagViaNumbers(arr2);
        assertTrue(Arrays.equals(new String[]{"B", "B", "B", "R", "R", "R", "W", "W", "W"}, arr2));
    }


}
