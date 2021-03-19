package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

public class Leetcode00092 {
    //    输入：head = [1,2,3,4,5], left = 2, right = 4
    //    输出：[1,4,3,2,5]
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        ListNode readyReverseNode = null; // 待翻转的节点
        ListNode restNode = null; // 剩余的节点

        ListNode tempNode = new ListNode(-1, head);
        ListNode headNode = tempNode; // 前驱节点
        for (int i = 0; i < left - 1; i++) {
            headNode = headNode.next;
        }
        while (node != null) {
            if (left == 1) {
                readyReverseNode = node;
            }
            if (right == 1) {
                restNode = node.next;
                node.next = null;
            }
            node = node.next;
            left--;
            right--;
        }
        if (readyReverseNode != null) {
            // 将 readyReverseNode 进行翻转
            ListNode areaNode = reverseNode(readyReverseNode);
            int size = 0;
            for (ListNode i_node = areaNode; i_node != null; i_node = i_node.next) {
                size++;
            }
            ListNode preNode = null;
            for (ListNode i_node = areaNode; i_node != null; i_node = i_node.next) {
                size--;
                if (size == 0) {
                    preNode = i_node;
                }
            }
            if (preNode != null) preNode.next = restNode;
            if (headNode != null) {
                headNode.next = areaNode;
            } else {
                headNode = areaNode;
            }
        }
        return tempNode.next;
    }

    ListNode lastNode = null;

    private ListNode reverseNode(ListNode node) {
        // 头插法 迭代
        ListNode tempNode = new ListNode(-1);
        for (ListNode n = node; n != null; n = n.next) {
            ListNode cur = new ListNode(n.val);
            tempNode.next = cur;
            cur.next = lastNode;
            lastNode = cur;
        }
        return tempNode.next;
    }


    /**
     * 重写一下
     * //    输入：head = [1,2,3,4,5], left = 2, right = 4
     * //    输出：[1,4,3,2,5]
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode tempNode = new ListNode(-1, head);
        // 第一步找到pre节点
        ListNode pre = tempNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 第二步找到翻转的头节点、剩余的尾节点
        ListNode readyReverse = pre.next;
        ListNode readyHead = new ListNode(-1, readyReverse);
        ListNode tail = null;
        for (int i = 0; i < right - left  + 1 ; i++) {
            readyHead = readyHead.next;
            if(i == right - left){
                // 最后一个节点
               tail =  readyHead.next;
               readyHead.next = null;
            }
        }
        // 第三步 反转中间链表
        ListNode hasReverse = reverseNode(readyReverse);

        // 第四步 中间链表尾巴给接上
        ListNode hasReverseNode = new ListNode(-1, hasReverse);
        while (hasReverseNode.next != null) {
            hasReverseNode = hasReverseNode.next;
        }
        hasReverseNode.next = tail;

        // 第五步 前驱指针接上
        pre.next = hasReverse;
        return tempNode.next;
    }


    public static class Test {
        public static void main(String[] args) {
            ListNode head = new ListNode(3);
            ListNode twoNode = new ListNode(5);
            ListNode threeNode = new ListNode(3);
            ListNode fourNode = new ListNode(4);
            ListNode fiveNode = new ListNode(5);

            head.next = twoNode;
//            twoNode.next = threeNode;
//            threeNode.next = fourNode;
//            fourNode.next = fiveNode;

            Leetcode00092 coLeetcode000206 = new Leetcode00092();
            ListNode resListNode = coLeetcode000206.reverseBetween2(head, 1, 1);
            System.out.println("=========================");
            System.out.println(resListNode.toString());
        }
    }
}
