package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode00102 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        levelOrder(node);
    }
    /**
     *  二叉树的层次遍历
     */
    // [3,9,20,null,null,15,7]
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> treeQ = new LinkedList<TreeNode>();
        if(root ==null) return result;
        treeQ.offer(root);
        while (!treeQ.isEmpty()) {
            int currentSize = treeQ.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = treeQ.poll();
                level.add(node.val);
                if(node.left !=null)treeQ.offer(node.left);
                if(node.right !=null)treeQ.offer(node.right);
            }
            result.add(level);
        }
        return result;
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
