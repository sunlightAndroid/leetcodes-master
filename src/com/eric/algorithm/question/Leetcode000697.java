package com.eric.algorithm.question;

import java.util.*;

public class Leetcode000697 {


    public int findShortestSubArray(int[] nums) {
        int result = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.set(0, list.get(0) + 1);
                list.set(2, i);
            } else {
                List<Integer> cur = new ArrayList<>();
                cur.add(1); // 当前数出现次数
                cur.add(i);  // 起点
                cur.add(i);  // 终点
                map.put(nums[i], cur);
            }
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = entries.iterator();
        int max = 0;
        int min = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            List<Integer> value = next.getValue();
            if (max < value.get(0)) {
                max = value.get(0);     // 最大的度
            }
        }
        Iterator<Map.Entry<Integer, List<Integer>>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = iterator2.next();
            List<Integer> value = next.getValue();
            if(value.get(0) == max){
                result = value.get(2) - value.get(1) + 1;
                min = Math.min(min,result);
            }
        }
        return min;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000697 solution = new Leetcode000697();
            int[] nums = {1,2,2,3,1,4,2};
            int shortestSubArray = solution.findShortestSubArray(nums);
            System.out.println(shortestSubArray);
        }
    }
}
