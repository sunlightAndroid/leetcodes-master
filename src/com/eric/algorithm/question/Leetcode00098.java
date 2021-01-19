package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;


public class Leetcode00098 {

    private boolean isValidBST = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValidBST;
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return true;
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (root.left == null && root.right == null) isValidBST = true;
        else isValidBST = l && r
                && isSmallerThanAll(root)
                && isBiggerThanAll(root);
        return isValidBST;
    }

    private boolean isSmallerThanAll(TreeNode node) {
        int current = node.val;
        TreeNode r = node.right;
        while (r != null) {
            if (r.val <= current) return false;
            r = r.left;
        }
        return true;
    }

    private boolean isBiggerThanAll(TreeNode node) {
        int current = node.val;
        TreeNode l = node.left;
        while (l != null) {
            if (l.val >= current) return false;
            l = l.right;
        }
        return true;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00098 solution = new Leetcode00098();
            boolean res = solution.isValidBST(createNode());
            System.out.println(res);
        }
    }


    private static TreeNode createNode() {
        TreeNode node = new TreeNode(1);
//        TreeNode left_two_node = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(9)));
        TreeNode left_two_node = new TreeNode(1);

        TreeNode right_two_node = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        node.left = left_two_node;
        node.right = null;
        return node;
    }
}
