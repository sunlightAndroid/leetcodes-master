package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节跳动的题目，每K个元素反转一次
 * 1->2->3->4->5 k=3
 * 3->2->1->5->4
 * <p>
 * [] -> 1
 * [] -> 2 1
 * [] -> 3    2 1
 */
public class Leetcode000206_II {
    public ListNode reverseList(ListNode head, int k) {
        ListNode tempNode = new ListNode(-1);
        int kk = k;
        ListNode lastNode = null;
        ListNode pre = new ListNode(-1);

        for (ListNode node = head; node != null; node = node.next) {
            if (kk > 0) {
                ListNode currentNode = new ListNode(node.val);
                tempNode.next = currentNode;
                currentNode.next = lastNode;
                lastNode = currentNode;
                kk--;
            } else {
                pre.next = tempNode.next;
                tempNode.next = null;
                lastNode = null;
                kk = k;
            }
        }
        if (kk > 0) {
            ListNode test = new ListNode(-1, pre);
            while (test.next != null) {
                test.next = test.next.next;
            }
            System.out.println();
//            //  pre 的后面去添加 temp
//            ListNode p = pre;
//            while (pre.next != null){
//                pre.next = pre.next.next;
//            }
//            p.next = tempNode;
        }
        return pre;
    }


    /**
     * 使用递归的方式
     */
    private List<ListNode> ans = new ArrayList<>();
    public ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode reverse = reverse(head.next, k - 1);
        head.next.next = head;
        head.next = null;
        ans.add(reverse);
        if (k == 0) {
            System.out.println(ans.toString());
            k=3;
        }
        return reverse;
    }


    public static class Test {
        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            ListNode twoNode = new ListNode(2);
            ListNode threeNode = new ListNode(3);
            ListNode fourNode = new ListNode(4);
            ListNode fiveNode = new ListNode(5);
            ListNode sixNode = new ListNode(6);

            head.next = twoNode;
            twoNode.next = threeNode;
            threeNode.next = fourNode;
            fourNode.next = fiveNode;
            fiveNode.next = sixNode;
            int k = 3;
            Leetcode000206_II coLeetcode000206 = new Leetcode000206_II();
            ListNode resListNode = coLeetcode000206.reverse(head, k);
            System.out.println("=========================");
            System.out.println(resListNode.toString());
        }
    }
}
