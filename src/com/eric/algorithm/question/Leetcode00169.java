package com.eric.algorithm.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Leetcode00169 {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int a = map.get(nums[i]);
                map.put(nums[i],++a);
            }else {
                map.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        int max = 0;
        int result = 0;
        while (iterator.hasNext()){
              Map.Entry<Integer, Integer> next = iterator.next();
              int key = next.getKey();
              int value = next.getValue();
              if(max < value){
                  max = value;
                  result = key;
              }
        }
        return result;
    }
    static class Test {
        public static void main(String[] args) {
            Leetcode00169 solution = new Leetcode00169();
            int[] array = new int[]{2,2,1};
            int result =  solution.majorityElement(array);
            System.out.println(result);
        }
    }
}
