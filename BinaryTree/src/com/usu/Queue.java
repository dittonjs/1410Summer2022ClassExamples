package com.usu;

public class Queue<T> {
    private class Node {
        T data;
        Node next;
    }
    private int size = 0;
    private Node head;
    private Node tail;

    public void enqueue(T data) {
        size++;
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }

    public T dequeue() {
       if (isEmpty()) return null;

       if (getSize() == 1) {
           size --;
           T data = head.data;
           head = null;
           tail = null;
           return data;
       }
       size --;
       T data = head.data;
       head = head.next;
       return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}
