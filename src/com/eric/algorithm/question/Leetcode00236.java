package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Leetcode00236 {

    /**
     * [3,5,1,6,2,0,8,null,null,7,4]
     * 5
     * 4
     */
    TreeNode resultNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        checkIsContainOne(root, p, q);
        return resultNode;
    }

    /**
     * 判断节点node 是否包含 p 或者 q
     * 自底向上，后续遍历
     */
    public boolean checkIsContainOne(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean l = checkIsContainOne(node.left, p, q);
        boolean r = checkIsContainOne(node.right, p, q);
        if (r && l || (l && node.val == q.val || l && node.val == p.val) || (r && node.val == p.val || r && node.val == q.val))
            resultNode = node;
        // 当前节点node包含p或者q ，或者当前节点node的左孩子or右孩子包含p或者q，都向上返回
        return node.val == p.val || node.val == q.val || (l || r);
    }


    //--------------------------分界线begin-----------------------//
    // 思路二： 既然要求最近的公共祖先，那么我可以先求p的祖先、q的祖先，两个祖先列表的交集就能找到最近的.(但是会超时)
    public TreeNode lowestCommonAncestors(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        pStack.push(root);
        while (!pStack.isEmpty()) {
            TreeNode node = pStack.peek();
            if (node == p) break;
            if (node.left == null && node.right == null) {
                TreeNode topNode = pStack.pop();
                pStack.push(topNode.right);
            } else if (node.left != null) {
                pStack.push(node.left);
            }
        }

        qStack.push(root);
        while (!qStack.isEmpty()) {
            TreeNode node = qStack.peek();
            if (node == q) break;
            if (node.left == null && node.right == null) {
                qStack.pop();
                TreeNode topNode = qStack.peek();
                qStack.push(topNode.right);
            } else if (node.left != null) {
                qStack.push(node.left);
            }
        }

        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();

        while (pStack.size() > 0) {
            TreeNode pop = pStack.pop();
            pList.add(pop);
        }
        while (qStack.size() > 0) {
            TreeNode pop = qStack.pop();
            qList.add(pop);
        }

        int i = pList.size() - 1;
        int j = qList.size() - 1;

        while (i >= 0 && j >= 0) {
            if(pList.get(i) == qList.get(j)){
                resultNode = pList.get(i);
            }else {
                break;
            }
            i--;j--;
        }
        return resultNode;
    }

    //--------------------------分界线end-----------------------//


    public static class Test {
        public static void main(String[] args) {
            Leetcode00236 solution = new Leetcode00236();
            TreeNode root = createNode();
            TreeNode p = root.left;
            TreeNode q = root.left.right.right;
//            TreeNode q = root.right;

            TreeNode resultNode = solution.lowestCommonAncestors(root, p, q);
//            TreeNode resultNode = solution.checkIsContains(root, p, q,false,false);
            System.out.println(resultNode.val);
        }
    }

    // [3,5,1,6,2,0,8,null,null,7,4]
    private static TreeNode createNode() {
        TreeNode node = new TreeNode(3);
        TreeNode left_two_node = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode right_two_node = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        node.left = left_two_node;
        node.right = right_two_node;
        return node;
    }
}
