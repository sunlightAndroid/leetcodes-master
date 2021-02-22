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
     * 方法二 递归回溯
     */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(int index, List<Integer> cur, int[] nums) {
        ans.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00078 solution = new Leetcode00078();
            int[] nums = {1, 2};
            List<List<Integer>> subsets = solution.subsets2(nums);
            System.out.println(subsets);
        }
    }

}
