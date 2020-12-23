package com.eric.algorithm.question;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode00104 {

    public static void main(String[] args) {
//		[0,2,4,1,null,3,-1,5,1,null,6,null,8]      true 4, my 5
        TreeNode node= new TreeNode(0,new TreeNode(2,new TreeNode(1, new TreeNode(5),new TreeNode(1)),
                null),

                new TreeNode(4, new TreeNode(3,null, new TreeNode(6)),
                        new TreeNode(-1, null, new TreeNode(8)) )
        );
        int  height = maxDepth2(node);
        System.out.println("height: " + height);
    }

    /**
     * 二叉树的层次遍历
     */
    // [3,9,20,null,null,15,7],
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int hight  = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left !=null) {
                    queue.offer(node.left);
                }
                if(node.right !=null) {
                    queue.offer(node.right);
                }
            }
            hight ++;
        }
        return hight;
    }

    /**
     *  方法二 ：递归的方式
     */
    public static int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
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
