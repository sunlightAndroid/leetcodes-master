package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode00101 {
    public static void main(String[] args) {
        // 	[1,2,2,null,3,3]

        TreeNode fisrt_node = new TreeNode(1);
        TreeNode second_left_node = new TreeNode(2);
        TreeNode second_right_node = new TreeNode(2);
        fisrt_node.left = second_left_node;
        fisrt_node.right = second_right_node;

        TreeNode third_left_one_node = new TreeNode(3);
        TreeNode third_left_two_node = new TreeNode(3);
        second_left_node.left = third_left_one_node;
        second_left_node.right = third_left_two_node;

        TreeNode third_right_one_node = new TreeNode(3);
        TreeNode third_right_two_node = new TreeNode(3);

        second_right_node.left = third_right_one_node;
        second_right_node.right = third_right_two_node;

        boolean result = isSymmetric2(fisrt_node);
        System.out.print(result);
    }

//------------------------begin--------------------------//
    /**
     * 对称二叉树，解法一：递归
     */
    public static boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
    }
    public static boolean dfs(TreeNode left,TreeNode right) {
        if(left==null && right == null) return true;
        if(left ==null || right == null) return false;
        if(left.val !=right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
//------------------------end--------------------------//



//------------------------begin--------------------------//
    /**
     * 解法二：队列的实现方式
     */
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        if(root.left ==null && root.right ==null) return true;
        if(root.left ==null || root.right ==null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (queue.size() > 0) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null && right ==null) continue;
            if(left==null || right ==null) return false;
            if(left.val !=right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
//------------------------end--------------------------//



    /**
     * 对称二叉树
     */
    // [1,2,2,3,4,4,3]
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode currentNode = null;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                currentNode = queue.poll();
                ans.add(currentNode.val);
                if(currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null) {
                    queue.offer(currentNode.right);
                }
            }
            level++;
            if(!check(level,ans)) {
                return false;
            }
        }
        return true;
    }

    public static boolean check(int level,List<Integer> ans ) {
        int i = 0; int j = ans.size() -1;
        while (i< j) {
            if(ans.get(i) != ans.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
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
