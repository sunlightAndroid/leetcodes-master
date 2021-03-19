package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Leetcode000437 {

    int count = 0;
    private List<List<Integer>> res = new ArrayList<>();
    private Map<TreeNode, Boolean> visited = new HashMap<>();
    private List<TreeNode> nodes = new ArrayList<>();
    private int sum;
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        travel(root);
        return count / 2;
    }

    private void travel(TreeNode node) {
        if (node == null) return;
        backtrack(node, sum, new ArrayList<>());
        travel(node.left);
        travel(node.right);
    }

    private void backtrack(TreeNode node, int sum, List<Integer> cur) {
        System.out.println("  " + cur.toString());
        if (sum == 0 && cur.size() > 0) {
            count++;
            res.add(new ArrayList<>(cur));
//            System.out.println("enable:  " + cur.toString());
        }
        if (node == null) return;

        if (!visited.containsKey(node) || !visited.get(node)) {
            cur.add(node.val);
            visited.put(node, true);
            backtrack(node.left, sum - node.val, cur);
            backtrack(node.right, sum - node.val, cur);
            // 撤销选择
            cur.remove(cur.size() - 1);
            visited.put(node, false);
        }
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000437 solution = new Leetcode000437();
            int result = solution.pathSum(createNode(), -1);
            System.out.println("================");
            System.out.println(result);
        }
    }


    private static TreeNode createNode() {
        TreeNode node = new TreeNode(1);
        TreeNode left_two_node = new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3, null, null));
        TreeNode right_two_node = new TreeNode(-3, new TreeNode(-200), null);
        node.left = left_two_node;
        node.right = right_two_node;
        return node;
    }
}
