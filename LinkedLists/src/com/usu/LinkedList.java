package com.usu;

public class LinkedList<T> {
    protected class Node {
        T data;
        Node next;
    }

    protected Node head = null;
    protected Node tail = null;
    protected Node current;


    public void insert(T value) {
        if (head == null) {
            head = new Node();
            head.data = value;
            tail = head;
            return;
        }

        Node newNode = new Node();
        newNode.data = value;
        tail.next = newNode;
        tail = tail.next;


        // if you dont have a tail reference then do this
        // if inserting the first item
//        if (head == null) {
//            head = new Node();
//            head.data = value;
//            return;
//        }

//        Node node = head;
//        while(node.next != null) {
//            node = node.next;
//        }
//        Node newNode = new Node();
//        newNode.data = value;
//        node.next = newNode;
    }

    public void display() {
        Node node = head;
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public boolean find(T value) {
        Node node = head;
        while(node != null) {
            if (node.data.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T value) {
        Node previous = null;
        Node current = head;
        while(current != null) {
            if (current.data.equals(value)) {
                if (current == head) {
                    if (head == tail) {
                       head = null;
                       tail = null;
                    } else {
                        head = head.next;
                    }
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return true;
            }
            previous = current;
            current = previous.next;
        }
        return false;
    }

    public T get(int index) {
        return get(index, 0, head);
    }

    private T get(int index, int i, Node node) {
        if (node == null) throw new IndexOutOfBoundsException("Bad index");
        if (i == index) return node.data;
        return get(index, i+1, node.next);
    }
}
