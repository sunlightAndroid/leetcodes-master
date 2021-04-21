package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

public class Leetcode001171 {
    /**
     * 输入：head = [1,2,-3,3,1]
     * 输出：[3,1] 或者 [1,2,1]
     *
     * 输入：head = [1,2,-3,4,1]
     * 输出：[4,1]
     */
    public ListNode removeZeroSumSublists(ListNode head) {







        return head;
    }

    public static void main(String[] args) {
        Leetcode001171 sulotion = new Leetcode001171();

        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;

//        ListNode listNode = sulotion.addTwoNumbers(l1, l2);
//        System.out.println(listNode.toString());

    }


}
