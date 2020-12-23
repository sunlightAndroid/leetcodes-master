package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0094 {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode();
        rootNode.val = 10;

        TreeNode leftNode = new TreeNode();
        leftNode.val = 1;
        rootNode.left = leftNode;

        TreeNode leftTwoNode = new TreeNode();
        leftTwoNode.val = 2;
        leftNode.left = leftTwoNode;

        TreeNode rightTwoNode = new TreeNode();
        rightTwoNode.val = 3;
        leftNode.right = rightTwoNode;


        List<Integer> result = inorderTraversal(rootNode);
        System.out.println(result.toString());
    }

    /**
     * 中序遍历 二叉树 （左-根-右）
     *
     * @param root [1,null,2,3]
     * @return [1,3,2]
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        travel(root,result);
        return result;
    }

    // 10 --> 1--> 2--> 3
    public static void travel(TreeNode root, List<Integer> result) {
        if(root !=null) System.out.println(root.val);
        if(root == null) return;
        travel(root.left,result);
        result.add(root.val);
        travel(root.right,result);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
