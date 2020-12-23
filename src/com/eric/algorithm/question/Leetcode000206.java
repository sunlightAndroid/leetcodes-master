package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

public class Leetcode000206 {
    public ListNode reverseList(ListNode head) {
        ListNode tempNode = new ListNode(-1,null);
        ListNode lastNode = null;
        for (ListNode node = head; node != null; node = node.next) {
            lastNode = tempNode.next;
            ListNode currentNode = new ListNode(node.val);
            tempNode.next = currentNode;
            currentNode.next = lastNode;
        }
        return tempNode.next;
    }

    public static class Test {
        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            ListNode twoNode = new ListNode(2);
            ListNode threeNode = new ListNode(3);
            ListNode fourNode = new ListNode(4);
            ListNode fiveNode = new ListNode(5);

            head.next = twoNode;
            twoNode.next = threeNode;
            threeNode.next = fourNode;
            fourNode.next = fiveNode;

            Leetcode000206 coLeetcode000206 = new Leetcode000206();
            ListNode resListNode  = coLeetcode000206.reverseList(head);
            System.out.println("=========================");
            System.out.println(resListNode.toString());
        }
    }
}
