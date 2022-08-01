package com.usu;

import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> data = new ArrayList<>();

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public void push(T value) {
        data.add(value);
    }

    public T pop() {
        T value = data.remove(data.size() - 1);
        return value;
    }
}
