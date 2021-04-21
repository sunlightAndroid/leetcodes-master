package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode0024 {

    //    输入：head = [1,2,3,4]
    //    输出：[2,1,4,3]

    /**
     * 迭代法
     */
    public ListNode swapPairs(ListNode head) {
        ListNode tempNode = new ListNode(-1, head);
        ListNode pNode = tempNode;
        while (pNode != null) {
            ListNode preNode = pNode;

            ListNode curNode = pNode.next;
            ListNode nextNode = curNode != null ? curNode.next : null;
            if (curNode != null && nextNode != null) {
                curNode.next = nextNode.next;
                preNode.next = nextNode;
                nextNode.next = curNode;
            }
            pNode = pNode.next;
            if (pNode != null) pNode = pNode.next;
        }
        return tempNode.next;
    }

    /**
     * 递归法
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1, head);

        return dummyNode.next;
    }


    public static void main(String[] args) {
        leetcode0024 solution = new leetcode0024();
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = solution.swapPairs(node2);
        System.out.println(node.toString());
        System.out.println(solution.swapPairs2(node2).toString());

    }

}
