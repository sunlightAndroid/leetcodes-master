package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode00046 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> cur) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            backtrack(nums, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode00046 solution = new Leetcode00046();
            int[] candidates = {1, 2};
            List<List<Integer>> permute = solution.permute(candidates);
            System.out.println(permute);
        }
    }
}
