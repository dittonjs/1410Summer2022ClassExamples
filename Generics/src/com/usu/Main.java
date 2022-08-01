package com.usu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        GenericStack<Integer> stack = new GenericStack<>();
//        stack.push(45);
//        stack.push(22);
//        stack.push(42);
//        stack.push(4345);
//        stack.push(2);
//
//        while(!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
//
//        GenericStack<String> cities = new GenericStack<String>();
//        cities.push("Logan");
//        cities.push("Providence");
//        cities.push("Hyrum");
//        cities.push("Mendon");
//
//        while(!cities.isEmpty()) {
//            System.out.println(cities.pop());
//        }

        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            values.add((int)(Math.random() * 100));
        }

        quickSort(values);

        for (int i : values) {
            System.out.println(i);
        }
        ArrayList<String> names = new ArrayList<>();

        names.add("Joseph");
        names.add("Catelyn");
        names.add("Sophie");
        names.add("Jeff");
        names.add("Daniel");

        quickSort(names);

        for (String name: names) {
            System.out.println(name);
        }
    }

    public static <T> void report(T value) {
        System.out.printf("%s\n", value);
    }

    public static <T extends Person> void reportPerson(ArrayList<T> person) {

    }

    public static void reportComparable(ArrayList<Comparable> values) {

    }

    public static <T extends Comparable<T>> void quickSort(ArrayList<T> data) {
        quickSort(data, 0, data.size() - 1);
    }

    public static <T extends Comparable<T>> void quickSort(ArrayList<T> data, int start, int end) {
        if (start > end) return;
        int index = partition(data, start, end);
        quickSort(data, start, index - 1);
        quickSort(data, index + 1, end);
    }

    public static <T extends Comparable<T>> int partition(ArrayList<T> data, int start, int end) {
        int middle = (start + end) / 2;
        swap(data, start, middle);

        int pivotIndex = start;
        for (int i = start + 1; i <= end; i ++) {
            if (data.get(i).compareTo(data.get(start)) < 0) {
                pivotIndex++;
                swap(data, pivotIndex, i);
            }
        }

        swap(data, start, pivotIndex);
        return pivotIndex;
    }

    public static <T> void swap(ArrayList<T> data, int pos1, int pos2) {
        T temp = data.get(pos1);
        data.set(pos1, data.get(pos2));
        data.set(pos2, temp);
    }
}

class Person {

}

class Student extends Person {

}
