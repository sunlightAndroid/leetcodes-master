package com.eric.algorithm.question;

import java.util.HashMap;

public class Leetcode000287 {

    // 方法一 哈希表
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        for (int num : nums) {
            if (hashtable.containsKey(num)) {
                return num;
            } else {
                hashtable.put(num, 1);
            }
        }
        return 0;
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode000287 solution = new Leetcode000287();
            int duplicate = solution.findDuplicate(null);
        }
    }

}
