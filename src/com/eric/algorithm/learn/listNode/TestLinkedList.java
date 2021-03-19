package com.eric.algorithm.learn.listNode;

public class TestLinkedList {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.print();

        linkedList.add(1,100);
        linkedList.print();

        linkedList.addLast(666);
        linkedList.print();
    }
}
