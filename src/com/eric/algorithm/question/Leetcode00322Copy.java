package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode00322Copy {


    int result = Integer.MAX_VALUE;
    private List<List<Integer>> ans = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        backtrack(coins, amount, 0 , new ArrayList<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    //  1, 2, 5  -->  11
    private void backtrack(int[] coins, int amount, int count ,List<Integer> cur ) {
        System.out.println(cur.toString());
        if(amount < 0) return;
        if (amount == 0) {
            result = Math.min(result, count);
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            cur.add(coins[i]);
            backtrack(coins, amount - coins[i], count + 1 , cur);
            // 撤销选择
            cur.remove(cur.size() - 1);
        }

    }


    public static void main(String[] args) {

        Leetcode00322Copy solution = new Leetcode00322Copy();

        int[] coins = {1, 2, 5};
        int amount = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int[] coins3 = {186, 419, 83, 408}; // 20
        int amount3 = 6249;

        int result = solution.coinChange(coins3, amount3);
        System.out.print("最终的个数 " + result);
    }


}
