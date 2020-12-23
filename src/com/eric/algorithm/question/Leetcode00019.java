package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

public class Leetcode00019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode pNode = dummyHead;
        ListNode qNode = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            qNode = qNode.next;
        }
        System.out.println("快：" + qNode.val + "  慢："+ pNode.val);
        while (qNode != null) {
            qNode = qNode.next;
            pNode = pNode.next;
        }
        pNode.next = pNode.next.next;
        return dummyHead.next;
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

            ListNode resultNode = removeNthFromEnd(head,2);
            System.out.print(resultNode.val);
        }
    }
}
