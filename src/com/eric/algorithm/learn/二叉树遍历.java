package com.eric.algorithm.learn;

import com.eric.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树遍历 {

    public void travel(TreeNode root) {
        if (root == null) return;
        travel(root.left);
        travel(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public void travel2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.val + " ");
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            System.out.println();
        }
    }

    /**
     * 非递归的实现方式
     * 采用栈
     */
    public void travelWithStack(TreeNode root) {
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                System.out.print(treeNode.val + " ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            // 左子树结束，弹出当前节点，从而访问右节点
            TreeNode node = stack.pop();
            treeNode = node.right;
        }
    }

    /**
     * 前序遍历：非递归的实现方式
     * 采用栈
     */
    public void travelsWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode currentNode = stack.pop();
            System.out.println(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if(currentNode.left != null){
                stack.push(currentNode.left);
            }
        }
    }


    public static class Test {
        public static void main(String[] args) {
            二叉树遍历 solution = new 二叉树遍历();
            solution.travelsWithStack(createNode());
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
