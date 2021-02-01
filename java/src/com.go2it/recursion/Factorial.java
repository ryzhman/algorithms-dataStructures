package com.go2it.recursion;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int calculateFactorial(int num) {
        if (memo.get(num) != null) {
            return memo.get(num);
        }
        if (num <= 1) {
            return 1;
        }
        final int result = num * calculateFactorial(num - 1);
        memo.put(num, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorial(4));
    }
}
