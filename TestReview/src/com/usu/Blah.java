package com.usu;

import java.util.Random;
import java.util.Scanner;

public class Blah {
    public final double PI = 3.14;

    public static void main(String[] args) {
//
//        // write your code here
//        // printing
//        System.out.println("asdf");
//        System.out.print("asdf");
//        System.out.printf("%d", 12);
//
//        // syntax
//
//        int[] values = new int[5];
//        int[] moreValues = {3,4,5,6,7,8};
//
//        int a = 10;
//        int A = 11;
//        double b = a;
//        int c = (int)b;
//
//        Scanner scanner = new Scanner(System.in);
//
//        boolean bool = true;
//        byte myByte = 1;
//        char myChar = '1';
//        short myShort = 2;
//        int myInt = 234786234;
//        float myFloat = 234.2349f;
//        long myLong = 23423498723487623l;
//        double myDouble = 234234.234987234987;

        int random = (int)(Math.random() * 1000000) + 1;

        Random random2 = new Random();
        random2.nextDouble();

        String myString = "asdfasdf";
        String result = "asdfasdf";

        String name = "Joseph";
        name += " Ditton";

        System.out.printf("%.2f", 3.149);
        for (int i = 0; i < 10; i++) {

        }

        int value = 10;
        doubleAValue(value);
        doubleAValue(value);
        trippleAValue(value);
        halfAValue(value);
        halfAValue(value);
        System.out.println(value);

    }

    public static void doubleAValue(int value) {
        value *= 2;
    }

    public static void trippleAValue(int value) {
        value *= 3;
    }

    public static void halfAValue(int value) {
        value /= 2;
    }

    public static methodName(int a): boolean {
        
    }

}
