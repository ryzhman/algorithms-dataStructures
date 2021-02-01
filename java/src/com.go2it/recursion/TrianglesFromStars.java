package com.go2it.recursion;

public class TrianglesFromStars {

    public static void main(String[] args) {
        printStars(4);
    }

    public static void printStars(int numInRow) {
        for (int i = 0; i < numInRow; i++) {
            System.out.print("*");
        }
        System.out.println();
        if (numInRow < 1) {
            return;
        }
        printStars(numInRow - 1);
    }
}
