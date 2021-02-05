package com.eric.algorithm.question.review;

import com.eric.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode00021 {

    //--------------------方法一 递归 begin----------------------//
    /**
     *  递归函数，作用：将l1链表与l2链表合并，返回一个更大的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
    //--------------------方法一 递归 end----------------------//


    public static void main(String[] args){
        Leetcode00021 sulotion = new Leetcode00021();

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
        ListNode listNode = sulotion.mergeTwoLists(l1, l2);
        System.out.println(listNode.toString());

    }


}
