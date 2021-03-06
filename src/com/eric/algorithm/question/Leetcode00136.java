package com.eric.algorithm.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Leetcode00136 {

    public int singleNumber(int[] nums) {
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
        while (iterator.hasNext()){
              Map.Entry<Integer, Integer> next = iterator.next();
              int key = next.getKey();
              int value = next.getValue();
              if(value == 1){
                  return key;
              }
        }
        return 0;
    }
    static class Test {
        public static void main(String[] args) {
            Leetcode00136 solution = new Leetcode00136();
            int[] array = new int[]{2,2,1};
            int result =  solution.singleNumber(array);
            System.out.println(result);
        }
    }
}
