package com.go2it.recursion;

public class Factorial {

    public static int calculateFactorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorial(4));
    }
}
