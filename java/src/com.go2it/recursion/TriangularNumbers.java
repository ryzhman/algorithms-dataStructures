package com.go2it.recursion;

/**
 * Calculates the number of dots in a a triangle that is of num depth.
 * https://www.mathsisfun.com/algebra/triangular-numbers.html
 */
public class TriangularNumbers {

    public static void main(String[] args) {
        System.out.println(isTriangularNumber(7));
    }

    public static int isTriangularNumber(int num) {
        if (num <= 1) {
            return 1;
        }
//        calculate the sum of existing dots in the current line
        return num + isTriangularNumber(num - 1);
    }
}
