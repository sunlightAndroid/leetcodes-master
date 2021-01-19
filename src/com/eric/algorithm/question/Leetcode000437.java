package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class Leetcode000437 {

    int count = 0;
    public int pathSum(TreeNode root, int sum) {

        return count;
    }
    private List<Integer> list = new ArrayList<>();
    private void dfs(TreeNode node) {
        if(node == null) return;
        list.add(node.val);

        dfs(node.left);
        dfs(node.right);
    }

    private void judge(){

    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000437 solution = new Leetcode000437();
        }
    }


    private static TreeNode createNode() {
        TreeNode node = new TreeNode(1);
        TreeNode left_two_node = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(9)));
        TreeNode right_two_node = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        node.left = left_two_node;
        node.right = right_two_node;
        return node;
    }
}
