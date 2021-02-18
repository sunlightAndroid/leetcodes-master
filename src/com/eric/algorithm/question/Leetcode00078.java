package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode00078 {

    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> lastResult = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        lastResult.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            result.clear();
            result.addAll(lastResult);
            int cur = nums[i];
            for (int j = 0; j < lastResult.size(); j++) {
                List<Integer> list = lastResult.get(j);
                List<Integer> values = new ArrayList<>();
                values.addAll(list);
                values.add(cur);
                result.add(values);
            }
            lastResult.clear();
            lastResult.addAll(result);
        }
        return result;
    }

    /**
     *  方法二 递归
     */
    public List<List<Integer>> subsets2(int[] nums) {
        return  dfs(nums.length - 1, nums);
    }

    private List<List<Integer>> dfs(int index,  int[] nums) {
//        System.out.println(result.toString());
        if (index == 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        int cur = nums[index];
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> last = dfs(index - 1, nums);
        for (int j = 0; j < last.size(); j++) {
            List<Integer> list = last.get(j);
            List<Integer> values = new ArrayList<>();
            values.addAll(list);
            values.add(cur);
            result.add(values);
        }

        return result;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00078 solution = new Leetcode00078();
            int[] nums = {1,2,3,4};
            List<List<Integer>> subsets = solution.subsets2(nums);
            System.out.println(subsets);
        }
    }

}
