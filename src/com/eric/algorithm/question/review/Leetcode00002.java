package com.eric.algorithm.question.review;

import com.eric.algorithm.model.ListNode;

public class Leetcode00002 {

    //--------------------方法一 递归 begin----------------------//

    /**
     * 递归函数，作用：将l1链表与l2链表合并，返回一个更大的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }
    //--------------------方法一 递归 end----------------------//


    public static void main(String[] args) {
        Leetcode00002 sulotion = new Leetcode00002();

        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;
//        ListNode listNode = sulotion.mergeTwoLists(l1, l2);
//        System.out.println(listNode.toString());

    }


}
