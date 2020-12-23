package com.eric.algorithm.question;

import java.util.Arrays;

public class Leetcode00322 {
    public static void main(String[] args) {

        int[] coins = { 1, 2, 5 };
        int amount = 11;

        int[] coins2 = { 2 };
        int amount2 = 3;

        int[] coins3 = { 186, 419, 83, 408 }; // 20
        int amount3 = 6249;

        // int result = coinChange(coins3, amount3);
//		int result = coinChange(0, coins3, amount3);

//		int result = coinChangeN(coins3, amount3);

        int result  = coinChange666(0,coins,amount);
        System.out.print("最终的个数 " + result);
    }

    /**
     * 动态规划求
     */
    public static int coinChangeN(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i == 0 ? 0 : -1;
        }
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    min = Math.min(min, 1 + dp[i - coins[j]]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    /**
     * 穷举递归每一种情况
     *
     * @param coins  [1,2,5]
     * @param amount 11
     * @return 3 （5*2 + 1）
     */
    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins.length == 0)
            return 0;
        return dfs(coins, amount, Integer.MAX_VALUE, 0);
    }

    // 1 2 5 11
    // 找出剩下的数组硬币 2 5 10
    public static int dfs2(int[] coins, int amount, int index, int minCount, int total) {
        if (index == coins.length - 1) {
            if (amount % coins[index] != 0) {
                minCount = Integer.MAX_VALUE;
                return -1;
            } else {
                int nums = amount / coins[index];
                total += nums;
                return Math.min(total, minCount);
            }
        }

        for (int i = index; i < coins.length; i++) {
        }
        return 0;
    }

    /**
     *  leetcode 暴力搜索模版
     *
     *   1 2 5 -- 11
     */
    public static int coinChange666(int idxCoin, int[] coins, int amount) {
//		 System.out.println("idxCoin:" + idxCoin + " amount:" + amount);
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange666(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                        System.out.println("======= " + minCost);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }


    // 1 2 5 11
    // 找出剩下的数组硬币 2 5 10
    public static int dfs(int[] coins, int amount, int minCount, int totalCount) {
        System.out.println("剩余的钱数 ：" + amount + "  minCount:" + minCount + "  totalCount:" + totalCount);
        if (amount == 0) {
            minCount = Math.min(minCount, totalCount);
            return minCount;
        }

        if (amount < 0 || useUp(coins))
            return -1;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] != -1 && coins[i] <= amount) {
                int current = coins[i];
                if (amount < current) {
                    minCount = -1;
                    totalCount = 0;
                    return -1;
                }
                int maxUse = amount / current;
                if (i == coins.length - 1) {
                    if (amount % current != 0) {
                        totalCount = 0;
                        minCount = 0;
                        return -1;
                    }
                }

                for (int j = i == coins.length - 1 ? 1 : 0; j <= maxUse; j++) {
                    int rest = amount - current * j;
                    coins[i] = -1;
                    if (rest < amount) {
                        totalCount++;
                    }
                    dfs(coins, rest, minCount, totalCount);
                }
            }
        }
        return minCount;
    }

    public static boolean useUp(int[] coins) {
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] != -1)
                return false;
        }
        return true;
    }

    /**
     * 找零钱问题
     *
     * @param coins  [1,2,5]
     * @param amount 11
     * @return 3 (11 = 5 + 5 + 1)
     *
     *         方法一 （不是最优解，相似解） 贪心算法
     */
    public static int coinChange(int[] coins, int amount) {

        int result = 0;
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));
        for (int i = coins.length - 1; i >= 0; i--) {
            int currentA = amount;
            result = 0;
            for (int j = i; j >= 0; j--) {
                if (currentA >= coins[j]) {
                    int num = currentA / coins[j];
                    result = result + num;
                    int rest = currentA % coins[j];
                    currentA = rest;
                }
                if (currentA == 0) {
                    return result;
                }
            }
        }
        return result == 0 ? -1 : result;
    }

    /**
     * 方法二
     */
    private static int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }
}
