package com.eric.algorithm.question;

public class Leetcode00309 {
    public static void main(String[] args) {

        int[] array = new int[] {1,2,3,0,2};
        int result = maxProfit3(array);
        System.out.print(result);
    }

    /**
     * 解法一： 暴力解法，双指针枚举每一种情况 数组的每一个索引其实就是三种情况之一： 买入、卖出、cooldown或者啥也不干
     */
    // [1,2,3,0,2]
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int max = 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] nothing = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
        }
        return max;
    }

    /**
     * https://segmentfault.com/a/1190000004193861 解法二： 可以认为每天只有两种状态，1.持有股票 2未持有股票
     * 如果第i天持有股票，怎么才是最大利润呢？ 那么求 i-1天持有的 与 如果第i天未持有股票，那么求
     */
    // [1,2,3,0,2]
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int max = 0;

        return max;
    }

    // [1,2,3,0,2]
    public static int maxProfit3(int[] prices) {
        if (prices.length <= 1)return 0;
        int max = 0;
        int len = prices.length;
        int[][] dp = new int[len][3];
        // dp[i][0] : 持有股票
        // dp[i][1] : 不持有股票，本日卖出，下一天为冷冻期
        // dp[i][2] : 不持有股票，本日无卖出，下一天非冷冻期

        // 第一天买入一股，那么当前收益就是负数，投进去了，等到卖出才能收益
        dp[0][0] = -prices[0];
        // 第一天都不持有股票，所以收益都是0
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 持有股票 昨天也是持有的 VS 今天刚买的 （昨天是非卖出的并且不是冷冻期）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 不持有股票，本日卖出， 那么上一天也是持有的，当前的收益为：
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 不持有股票，本日无卖出， 那么昨天不可能持有股票
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
