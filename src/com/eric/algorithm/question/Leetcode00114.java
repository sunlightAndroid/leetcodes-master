package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;


public class Leetcode00114 {

    public void flatten(TreeNode root) {
        travel(root);
    }

    /**
     * 递归函数
     * 将节点node左子树移动到右边
     */
    public TreeNode travel(TreeNode node) {
        if (node == null) return null;
        TreeNode l = travel(node.left);
        TreeNode r = travel(node.right);
        if(l != null ){
            node.right = l;
            node.left = null;
            // 要用当前的末端去链接 r
            // 即l的末端
            while ( l.right !=null){
                l = l.right;
            }
            l.right = r;
        }
        return node;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00114 solution = new Leetcode00114();
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
