package com.eric.algorithm.learn.listNode;

import com.eric.algorithm.model.ListNode;

public class LinkedList implements ListInterface {

    private ListNode head;
    private int size = 0;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void addFirst(int e) {
        ListNode cur = new ListNode(e);
        cur.next = head;
        head = cur;
        size++;
    }

    @Override
    public void add(int index, int e) {
        if (index < 0 || index > size) throw new IllegalStateException("index 参数错误");
        if (head == null) head = new ListNode();
        ListNode pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = new ListNode(e);
        cur.next = pre.next;
        pre.next = cur;
        size++;
    }

    @Override
    public void addLast(int e) {
        add(size, e);
    }

    @Override
    public int getSize() {
        return size;
    }

    public void print() {
        if (head == null) return;
        System.out.println(head.toString());
    }

}
