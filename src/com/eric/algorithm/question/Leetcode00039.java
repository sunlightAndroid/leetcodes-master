package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode00039 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curList = new ArrayList<>();
        backtracking(0, target, curList, candidates);
        return result;
    }

    private void backtracking(int index, int target, List<Integer> curList, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(curList));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            curList.add(candidates[i]);
            backtracking(i, target - candidates[i], curList, candidates);
            // 撤销选择 回溯
            curList.remove(curList.size() - 1);
        }
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode00039 solution = new Leetcode00039();
            int[] candidates = {2,3,5};
            int target = 8;
            List<List<Integer>> lists = solution.combinationSum(candidates, target);
            System.out.println(lists);
        }
    }
}
