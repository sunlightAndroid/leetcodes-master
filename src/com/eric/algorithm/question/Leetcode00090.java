package com.eric.algorithm.question;

import java.util.*;

public class Leetcode00090 {

    /**
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrace(int[] nums, int index, List<Integer> cur) {
        ans.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            // 加上剪枝操作, 相同层, 如果当前元素与上一个元素相同, 则跳过不遍历以实现剪枝.
            // i > index了，肯定是for循环中的i++执行了，所以肯定在同一层！！！，所以剪枝的操作就是这样的
            if (i > index && nums[i - 1] == nums[i]) continue;
            cur.add(nums[i]);
            backtrace(nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
//     if (i - 1 >= index && nums[i - 1] == nums[i]) continue; 相同层被剪掉
//     if (nums[i - 1] == nums[i]) continue;      // 同一树枝被剪掉

    public static class Test {
        public static void main(String[] args) {
            Leetcode00090 solution = new Leetcode00090();
            int[] nums = {1, 2, 3};
            List<List<Integer>> lists = solution.subsetsWithDup(nums);
            List<List<Integer>> lists2 = solution.subsetsWithDup2(nums);

            System.out.println(lists.toString());
        }
    }

    //------------------参考解法----------------------//
    int n;
    List<List<Integer>> result = new LinkedList();
    Stack<Integer> path = new Stack();

    // 加上剪枝操作, 相同层, 如果当前元素与上一个元素相同, 则跳过不遍历以实现剪枝.
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        if (nums.length <= 0) return result;
        n = nums.length;

        // 先排序, 这是很重要的.
        Arrays.sort(nums);

        dfs(nums, 0);

        return result;
    }

    public void dfs(int[] nums, int start) {
        result.add(new LinkedList(path));

        for (int i = start; i < n; i++) {
            if ((i - 1) >= start && nums[i - 1] == nums[i]) continue;
            path.push(nums[i]);
            dfs(nums, i + 1);
            path.pop();
        }

    }

}
