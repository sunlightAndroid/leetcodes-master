package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;

public class Leetcode00226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left =  invertTree(root.left);
        TreeNode right  = invertTree(root.right);
        TreeNode tempNode = left;
        root.left = right;
        root.right = tempNode;
        return root;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00226 solution = new Leetcode00226();
        }
    }
}
