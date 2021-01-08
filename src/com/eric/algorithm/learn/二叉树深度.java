package com.eric.algorithm.learn;

import com.eric.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树深度 {

    int ans = 0; // 节点数目
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return ans > 0 ? ans - 1 : ans;
    }

    /**
     * 求node的高度
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
            二叉树深度 solution = new 二叉树深度();
//            solution.travel(createNode());
        }
    }

    private static TreeNode createNode() {
        TreeNode node = new TreeNode(1);
        TreeNode left_two_node = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right_two_node = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        node.left = left_two_node;
        node.right = right_two_node;
        return node;
    }
}
