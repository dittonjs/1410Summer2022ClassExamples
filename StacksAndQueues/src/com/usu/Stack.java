package com.usu;

public class Stack<T> {
    private class Node {
        T value;
        Node next;
    }
    private Node head;
    public void push(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
    }

    public T pop() {
        if (head == null) return null;
        T value = head.value;
        head = head.next;
        return value;
    }

    public T peek() {
        if (head == null) return null;
        return head.value;
    }
}
