package com.eric.algorithm.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (ListNode node = this; node != null; node = node.next) {
            builder.append(node.val + " ");
        }
        builder.append(" ]");
        return builder.toString();
    }
}
