package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

public class Leetcode000141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)return false;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (true) {
            if(fastNode.next == null) return false;
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode)return true;
            if (fastNode == null || slowNode == null)return false;
        }
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

            Leetcode000141 coLeetcode000206 = new Leetcode000141();
            boolean hasCycle = coLeetcode000206.hasCycle(head);
            System.out.println("=========================" + hasCycle);
        }
    }
}
