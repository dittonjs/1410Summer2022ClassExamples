package com.usu;

public class MyStringBuilder {
    private String currentString = "";
    public MyStringBuilder append(String string) {
        currentString += string;
        return this;
    }

    @Override
    public String toString() {
        return currentString;
    }
}
