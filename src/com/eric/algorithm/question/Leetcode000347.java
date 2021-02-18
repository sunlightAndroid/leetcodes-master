package com.eric.algorithm.question;

import com.eric.algorithm.learn.sort.Utils;

import java.util.*;

public class Leetcode000347 {


    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (map.containsKey(currentNum)) {
                map.put(currentNum, map.get(currentNum) + 1);
            } else {
                map.put(currentNum, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int size = map.entrySet().size();
        int[] valueArray = new int[size];
        int index = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            valueArray[index++] = next.getValue();
        }
        Arrays.sort(valueArray);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (int i = 0; i < k; i++) {
            int l = valueArray.length - 1 - i;
            int c = valueArray[l];

            Iterator<Map.Entry<Integer, Integer>> iterator2 = entries.iterator();
            while (iterator2.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator2.next();
                if (next.getValue() == c) {
                    result[i] = next.getKey();
                    break;
                }
            }
        }
        return result;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000347 solution = new Leetcode000347();

            int[] nums = {1, 1, 1, 3, 3, 2, 2, 2, 4, 4, 4, 4};
            int k = 2;

            int[] nums1 = {3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6, 10};
            int k1 = 10;

            int[] nums2 = {1, 1, 1, 2, 2, 3};
            int k2 = 2;

            int[] result = solution.topKFrequent(nums1, k1);
            Utils.printArray(result);
        }
    }

}
