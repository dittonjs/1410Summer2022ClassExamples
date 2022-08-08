package com.usu;

public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    @Override
    public void insert(T value) {
        Node newNode = new Node();
        newNode.data = value;
        if (head == null) {
            head = newNode;
            return;
        }
        Node previous = null;
        Node current = head;
        while(current != null) {
            if (value.compareTo(current.data) < 0) {
                if (previous == null) {
                    head = newNode;
                    head.next = current;
                } else {
                    previous.next = newNode;
                    newNode.next = current;
                }
                break;
            }
            previous = current;
            if (current.next == null) {
                previous.next = newNode;
                break;
            }
            current = current.next;
        }
    }
}
