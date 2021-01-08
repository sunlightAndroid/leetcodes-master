package com.eric.algorithm.question;

import com.eric.algorithm.model.TreeNode;


public class Leetcode00236 {

    /**
     * [3,5,1,6,2,0,8,null,null,7,4]
     * 5
     * 4
     * <p>
     * 输出3
     * 预期5
     */
    TreeNode resultNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        TreeNode zz=  checkIsContains(root, p, q, false,false);
        if (resultNode == null && zz!=null)
            resultNode = zz;
        System.out.println(resultNode == null ? "null" : resultNode.val);
        return resultNode;
    }

    /**
     * 判断节点node 是否包含 p q
     */
    public TreeNode checkIsContains(TreeNode node, TreeNode p, TreeNode q , boolean pC, boolean qC) {
        if (node == null) return null;
        if (node == p) pC = true;
        if (node == q) qC = true;
        checkIsContains(node.left, p, q,pC,qC);
        checkIsContains(node.right, p, q,pC,qC);
        if (pC && qC) return node;
        return null;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00236 solution = new Leetcode00236();
            TreeNode root = createNode();
            TreeNode p = root.left;
//            TreeNode q = root.left.right.right;
            TreeNode q = root.right;

//            TreeNode resultNode = solution.lowestCommonAncestor(root, p, q);
            TreeNode resultNode = solution.checkIsContains(root, p, q,false,false);
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
