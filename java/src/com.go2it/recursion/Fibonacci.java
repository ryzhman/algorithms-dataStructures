package com.go2it.recursion;

public class Fibonacci {

    public static int calculateFibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return calculateFibonacci(num - 1) + calculateFibonacci(num - 2);
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(9));
    }
}
