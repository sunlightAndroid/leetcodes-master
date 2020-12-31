package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;

public class Leetcode00617 {

    /**
     * 前序遍历
     * 合并到左子树
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode node = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        // 前序遍历
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }

    public TreeNode travel(TreeNode node) {
        if (node == null) return null;
        TreeNode left = travel(node.left);
        TreeNode right = travel(node.right);

        left.left.val = left.left.val + right.left.val;
        left.right.val = left.right.val + right.right.val;
        return node;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00617 solution = new Leetcode00617();
        }
    }
}
