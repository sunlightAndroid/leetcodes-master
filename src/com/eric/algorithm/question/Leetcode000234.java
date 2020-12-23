package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

import java.util.ArrayList;

public class Leetcode000234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }

        int i = 0;
        int j = list.size() - 1;

        while (i <= j) {
            int a = list.get(i);
            int b = list.get(j);
            if (a != b) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static class Test {
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

            Leetcode000234 coLeetcode000206 = new Leetcode000234();
            boolean isPalindrome = coLeetcode000206.isPalindrome(head);
            System.out.println("=========================" + isPalindrome);
        }
    }
}
