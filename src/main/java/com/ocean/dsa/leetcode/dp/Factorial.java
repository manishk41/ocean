package com.ocean.dsa.leetcode.dp;

public class Factorial {

    private static int factorial(int n) {
        System.out.println("I am calculating factorial of " + n);
        if(n == 0)
            return 1;
        int fact = n * factorial(n-1);
        System.out.println("Done. factorial of " + n +" is: " + fact);
        return fact;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }
}