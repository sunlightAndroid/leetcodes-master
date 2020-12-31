package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;


public class Leetcode00543 {

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
//        return 0; // 返回该节点为根的子树的深度
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
