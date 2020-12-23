package com.eric.algorithm.question;

import com.eric.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode00021 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null) return l2;
        if(l2 ==null) return l1;
        ListNode trmpNode  =  l1;
        while (trmpNode.next!=null) {
            trmpNode = trmpNode.next;
        }
        trmpNode.next = l2;
        ListNode tempNode = new ListNode(0,l1);
        if(tempNode.next == null || tempNode.next.next ==null) return tempNode.next;
        List<Integer> list = new ArrayList<Integer>();
        for ( ListNode node  = tempNode.next; node !=null; node = node.next) {
            list.add(node.val);
        }
        List<Integer> resultlist = sort(list);
        ListNode headNode = new ListNode(0);
        ListNode currentNode =headNode;
        for (int i = 0; i < resultlist.size(); i++) {
            currentNode.val = resultlist.get(i);
            if(i <resultlist.size()-1) {
                currentNode.next = new ListNode(-1);
                currentNode = currentNode.next;
            }
        }
        return headNode;
    }

    private static List<Integer> sort(List<Integer> list ) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i+1; j < list.size(); j++) {
                if( list.get(minIndex) > list.get(j)) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
        return list;
    }



    public static class Test {
        public static void main(String[] args) {
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

            mergeTwoLists(l1,l2);

        }
    }
}
