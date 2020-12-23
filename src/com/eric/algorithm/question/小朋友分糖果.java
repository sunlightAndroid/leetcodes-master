package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class 小朋友分糖果 {

    public static void main(String[] args) {
        int[] candies = new int[] { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        List<Boolean> results = kidsWithCandies(candies, extraCandies);
        for (int i = 0; i < results.size(); i++) {

            System.out.print(results.get(i) + ",");
        }
    }

    /**
     * Input: candies = [2,3,5,1,3],//每个小朋友手中的 extraCandies = 3 //剩余3个糖果
     *
     * //现在最多的是5，那么小朋友加上剩余的糖果能变成最多的，也就是5吗 Output: [true,true,true,false,true]
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> resultBooleans = new ArrayList<Boolean>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            int candie = candies[i];
            if (candie >= max) {
                max = candie;
            }
        }

        for (int i = 0; i < candies.length; i++) {
            int candie = candies[i];
            resultBooleans.add(candie + extraCandies >= max);
        }

        return resultBooleans;
    }
}
