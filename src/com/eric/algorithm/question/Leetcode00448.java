package com.eric.algorithm.question;

import java.util.*;

public class Leetcode00448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i+1, true);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], false);
            }
        }
        Iterator<Map.Entry<Integer, Boolean>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Boolean> next = iterator.next();
            if(next.getValue()){
                result.add(next.getKey());
            }
        }
        return result;
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode00448 solution = new Leetcode00448();
        }
    }
}
