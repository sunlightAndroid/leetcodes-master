package com.eric.algorithm.question.review;

import com.eric.algorithm.model.ListNode;

public class Leetcode00002 {

    //--------------------方法一 递归 begin----------------------//

    /**
     * 递归函数，作用：将l1链表与l2链表合并，返回一个更大的链表
     * l1 = [2,4,3], l2 = [5,6,4] ==> [7,0,8]
     *
     * l1 = [9,9,9,9,9,9,9], l2 =[9,9,9,9] ==> [8,9,9,9,0,0,0,1]
     *                                error    [8,9,9,9,0,0,0]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummyNode = new ListNode(-1);
        ListNode tempNode = dummyNode;
        boolean needAdd = false;
        while (l1 != null && l2 != null) {
            int cur = l1.val + l2.val + (needAdd ? 1 : 0);
            if (cur >= 10) {
                needAdd = true;
                cur = cur % 10;
            } else {
                needAdd = false;
            }
            tempNode.next = new ListNode(cur);

            l1 = l1.next;
            l2 = l2.next;
            tempNode = tempNode.next;
        }

        if(l1 !=null){
            while (l1 !=null){
                int cur = l1.val + (needAdd ? 1 : 0);
                if (cur >= 10) {
                    needAdd = true;
                    cur = cur % 10;
                } else {
                    needAdd = false;
                }
                tempNode.next = new ListNode(cur);
                l1 = l1.next;
                tempNode = tempNode.next;
            }

        }else if(l2 !=null){
            while (l2 !=null){
                int cur = l2.val + (needAdd ? 1 : 0);
                if (cur >= 10) {
                    needAdd = true;
                    cur = cur % 10;
                } else {
                    needAdd = false;
                }
                tempNode.next = new ListNode(cur);
                l2 = l2.next;
                tempNode = tempNode.next;
            }
        }

        if(needAdd){
            tempNode.next = new ListNode(1);
        }
        return dummyNode.next;
    }
    //--------------------方法一 递归 end----------------------//

    public static void main(String[] args) {
        Leetcode00002 sulotion = new Leetcode00002();

        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;

        ListNode listNode = sulotion.addTwoNumbers(l1, l2);
        System.out.println(listNode.toString());

    }


}
