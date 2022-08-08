package com.usu;

import java.lang.reflect.Array;

public class FixedSizeQueue {
    private int[] data;
    int start = 0;
    int end = 0;
    int numElements = 0;

    public FixedSizeQueue(int size) {
        if (size <= 0) throw new RuntimeException("Queue size must be at least 1");
        data = new int[size];
    }

    public void enqueue(int value) {
        if (numElements == data.length) {
            throw new RuntimeException("Queue is full!");
        }
        numElements ++;
        data[end] = value;
        end ++;
        if (end == data.length) {
            end = 0;
        }
    }

    public int dequeue() {
        if (numElements == 0) throw new RuntimeException("Queue is empty");
        numElements  --;
        int value = data[start];
        start ++;
        if (start == data.length) {
            start = 0;
        }
        return value;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }
}
