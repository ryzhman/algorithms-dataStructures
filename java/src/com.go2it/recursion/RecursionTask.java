package com.go2it.recursion;

public class RecursionTask {

    public static void main(String[] args) {
        System.out.println(test(5,3));
    }

    static int test (int n, int r) {
        if (r == 0) {
            return 1;
        }
        if (r == 1) {
            return n;
        }
        if (r==n) {
            return 1;
        }
        return test(n-1, r-1) + test(n-1, r+1);
    }
}
