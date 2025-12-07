package com.ocean.dsa.leetcode.dp;

public class FibonacciNumber {

    // ---------- LeetCode 509: Fibonacci (Iterative O(n)) ----------
    public int fib(int n) {
        int[] dp = new int[n+1];
        return fibMemoized(n, dp);
    }

    // ---------- Memoized (Bottom-Up DP) ----------
    public int fibMemoized(int n, int[] dp) {
        if(n == 0)
            return 0;
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // ---------- Memoized (Top-Down DP) ----------
    public int fibMemoizedRec(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return n;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int fibnm1 = fibMemoizedRec(n-1, dp);
        int fibnm2 = fibMemoizedRec(n-2, dp);

        int fibn = fibnm1 + fibnm2;
        dp[n] = fibn;

        return fibn;
    }

    public static void main(String[] args) {

        FibonacciNumber obj = new FibonacciNumber();

        // ----------- TEST CASES -----------

        System.out.println("Test 1 (n=0 expected=0): " + obj.fib(0));
        System.out.println("Test 2 (n=1 expected=1): " + obj.fib(1));
        System.out.println("Test 3 (n=2 expected=1): " + obj.fib(2));
        System.out.println("Test 4 (n=3 expected=2): " + obj.fib(3));
        System.out.println("Test 5 (n=10 expected=55): " + obj.fib(10));
        System.out.println("Test 6 (n=20 expected=6765): " + obj.fib(20));

        // Memoized version
        System.out.println("Memoized (n=30 expected=832040): " + obj.fib(30));

        // Recursive (only for small n)
        System.out.println("Recursive (n=5 expected=5): " + obj.fib(5));
    }
}