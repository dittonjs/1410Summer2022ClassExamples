package com.usu;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter in some names (type stop to exit): ");
        String[] values = new String[5];
        ArrayList<String> names = new ArrayList<>();
        while(true) {
            String input = scanner.next();
            if (input.equals("stop")) {
                break;
            }
            names.add(input);
        }
        names.removeIf((name) -> name.startsWith("J"));
        sortNames(names);
        displayNames(names);

        // write your code here
    }

    public static void sortNames(ArrayList<String> names) {
        names.sort((string1, string2) -> string1.compareTo(string2));
    }

    public static void displayNames(ArrayList<String> names) {
        names.forEach(name -> System.out.println(name));
    }
}
