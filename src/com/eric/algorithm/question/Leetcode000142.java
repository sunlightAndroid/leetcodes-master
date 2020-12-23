package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

import java.util.HashMap;

public class Leetcode000142 {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, ListNode> maps = new HashMap<ListNode, ListNode>();
        for (ListNode node = head; node != null; node = node.next) {
            if(maps.containsKey(node)) {
                return node;
            }else {
                maps.put(node, node);
            }
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

            Leetcode000142 coLeetcode000206 = new Leetcode000142();
            coLeetcode000206.detectCycle(head);
            System.out.println("=========================");
        }
    }

}
