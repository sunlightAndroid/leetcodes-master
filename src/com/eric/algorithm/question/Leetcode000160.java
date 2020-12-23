package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

import java.util.HashSet;

public class Leetcode000160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> mapSet = new HashSet<ListNode>();
        for (ListNode node = headA; node !=null; node = node.next) {
            mapSet.add(node);
        }
        for (ListNode node = headB; node !=null; node = node.next) {
            if(mapSet.contains(node)) return node;
        }
        return null;
    }

    public static class  Test{
        public static void main(String[] args) {
            ListNode head = new ListNode(-129);
            ListNode twoNode = new ListNode(-129);
//			ListNode threeNode = new ListNode(3);
//			ListNode fourNode = new ListNode(2);
//			ListNode fiveNode = new ListNode(1);

            head.next = twoNode;
//			twoNode.next = threeNode;
//			threeNode.next = fourNode;
//			fourNode.next = fiveNode;

            Leetcode000160 coLeetcode000206 = new Leetcode000160();
            System.out.println("=========================");
        }
    }
}
