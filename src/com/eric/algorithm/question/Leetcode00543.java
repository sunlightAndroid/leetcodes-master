package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;


public class Leetcode00543 {

    int ans = 0; // 节点数目
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return ans > 0 ? ans - 1 : ans;
    }

    /**
     * 递归函数
     * 用于求节点为node的高度
     */
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode00543 solution = new Leetcode00543();
            int depth = solution.diameterOfBinaryTree(createNode());
            System.out.println(depth);
        }
    }


    private static TreeNode createNode() {
        TreeNode node = new TreeNode(1);
        TreeNode left_two_node = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(9)));
        TreeNode right_two_node = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        node.left = left_two_node;
        node.right = right_two_node;
        return node;
    }
}
