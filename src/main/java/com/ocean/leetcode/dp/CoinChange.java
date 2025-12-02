package com.ocean.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 0; // 0 coins to make 0
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // ---------- LeetCode 322: Coin Change (DP Bottom-Up) ----------
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // impossible large number

        dp[0] = 0; // 0 coins to make 0
        for (int coin : coins) {
            System.out.println("----------------- " + coin + ", dp[amount] = " + dp[amount] +" -----------------");
            for (int i = coin; i <= amount; i++) {
                System.out.println("dp[i]=" + dp[i] + ", dp[" + i + " - " + coin + "]=" + dp[i - coin]);
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();

        // ----------- TEST CASES -----------

        // Case 1
        int[] c1 = {1, 2, 5};
        System.out.println("Test 1 (expected: 3): " + obj.coinChange(c1, 11));

        // Case 2
        int[] c2 = {2};
        System.out.println("Test 2 (expected: -1): " + obj.coinChange(c2, 3));

        // Case 3
        int[] c3 = {1};
        System.out.println("Test 3 (expected: 0): " + obj.coinChange(c3, 0));

        // Case 4
        int[] c4 = {1, 3, 4};
        System.out.println("Test 4 (expected: 2): " + obj.coinChange(c4, 6)); // 3+3

        // Case 5
        int[] c5 = {2, 5, 10, 1};
        System.out.println("Test 5 (expected: 4): " + obj.coinChange(c5, 27)); // 10+10+5+2

//         Case 6 impossible
        int[] c6 = {5, 7};
        System.out.println("Test 6 (expected: -1): " + obj.coinChange(c6, 1));

        // Case 7
        int[] c7 = {27,40,244,168,383};
        System.out.println("Test 7 (expected: 23): " + obj.coinChange(c7, 6989));
    }
}