package com.usu;

public class Main {

    public static void main(String[] args) {
        SortedLinkedList<Integer> numbers = new SortedLinkedList<>();

        numbers.insert(10);
        numbers.insert(1);
        numbers.insert(34);
        numbers.insert(15);
        numbers.insert(234);
        numbers.insert(55);

        numbers.display();
	// write your code here
    }
}
