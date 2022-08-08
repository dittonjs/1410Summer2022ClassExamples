package com.usu;

public class FixedSizeStack {
    private int[] data;
    int top = 0;

    public FixedSizeStack(int size) {
        if (size <= 0) throw new RuntimeException("Stack size must be at least 1");
        data = new int[size];
    }

    public void push(int value) {
        if (top == data.length) throw new StackOverflowError();
        data[top] = value;
        top ++;
    }

    public int pop() {
        if (top == 0) throw new RuntimeException("Stack is empty");
        top --;
        return data[top];
    }
}
