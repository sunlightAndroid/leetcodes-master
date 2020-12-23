package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

public class Leetcode000148 {
    /**
     * 选择排序
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        for (ListNode node = head; node !=null; node = node.next) {
            ListNode minNode = node;
            for (ListNode jNode = node.next; jNode !=null; jNode = jNode.next) {
                if(minNode.val > jNode.val) {
                    minNode = jNode;
                }
            }
            if(minNode != node) {
                int tempV  = node.val;
                node.val = minNode.val;
                minNode.val = tempV;
            }
        }
        return head;
    }


    /**
     * 归并排序
     */
    public ListNode mergeSort(ListNode head, ListNode tail) {
        if(head == null) return head;
        if(head.next == tail) {
            head.next = null;
            return head;
        }

        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
//		while (fast !=tail && fast.next != tail) {
//			fast = fast.next.next;
//			slow = slow.next;
//		}
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        // slow 即为中点，奇数的话正好是中点123，偶数的话靠左边1234
        ListNode mid = slow;
        ListNode list1 = mergeSort(head,mid);
        ListNode list2 = mergeSort(mid.next,fast);
        return merge(list1, list2);
    }

    ListNode tempNode = new ListNode(0);
    public ListNode merge(ListNode list1, ListNode list2) {
        System.out.println(list1.toString() + "=====" + list2.toString());
        ListNode pointA =list1;
        ListNode pointB =list2;
        ListNode pointC =tempNode;
        while (pointA!=null && pointB !=null) {
            if(pointA.val < pointB.val) {
                pointC.next = pointA;
                pointA = pointA.next;
            }else {
                pointC.next = pointB;
                pointB = pointB.next;
            }
            pointC = pointC.next;
        }
        if(pointA !=null) {
            pointC.next = pointA;
        }else if(pointB !=null) {
            pointC.next = pointB;
        }
        return tempNode.next;
    }

    public static class  Test{
        public static void main(String[] args) {
            ListNode head = new ListNode(5);
            ListNode twoNode = new ListNode(2);
            ListNode threeNode = new ListNode(1);
            ListNode fourNode = new ListNode(3);
            ListNode fiveNode = new ListNode(4);

            head.next = twoNode;
            twoNode.next = threeNode;
//			threeNode.next = fourNode;
//			fourNode.next = fiveNode;

            Leetcode000148 leetcode000148 = new Leetcode000148();
            ListNode resListNode = leetcode000148.mergeSort(head,null);
            System.out.println("result:  " + resListNode.toString());
        }
    }
}
