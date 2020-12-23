package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode00103 {
    public static void main(String[] args) {
        List<List<Integer>> resultList = 	zigzagLevelOrder(createNode());
        System.out.print(resultList.toString());

    }
    /**
     *  二叉树的锯齿形遍历
     *  即 先从左到右，再从右到左
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> treeQ = new LinkedList<TreeNode>();
        if(root ==null) return result;
        treeQ.offer(root);
        boolean is_left_fisrt= false;
        while (!treeQ.isEmpty()) {
            int currentSize = treeQ.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = treeQ.poll();
                level.add(node.val);
                if(is_left_fisrt){
                    if(node.left !=null)treeQ.offer(node.left);
                    if(node.right !=null)treeQ.offer(node.right);
                }else {
                    if(node.right !=null)treeQ.offer(node.right);
                    if(node.left !=null)treeQ.offer(node.left);
                }

//				if(node.right !=null)treeQ.offer(node.right);
//				if(node.left !=null)treeQ.offer(node.left);
            }
            result.add(level);
            is_left_fisrt = !is_left_fisrt;
        }
        return result;
    }


    private static TreeNode createNode() {
        TreeNode node = new TreeNode(1);
        TreeNode left_two_node = new TreeNode(2,new TreeNode(4), new TreeNode(5));
        TreeNode right_two_node = new TreeNode(3,new TreeNode(6),new TreeNode(7));
        node.left = left_two_node;
        node.right = right_two_node;
        return node;

//
//		TreeNode node= new TreeNode(0,new TreeNode(2,new TreeNode(1, new TreeNode(5),new TreeNode(1)),
//				null),
//
//				new TreeNode(4, new TreeNode(3,null, new TreeNode(6)),
//						new TreeNode(-1, null, new TreeNode(8)) )
//				);
//
//		return node;
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
