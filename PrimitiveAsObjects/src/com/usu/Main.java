package com.usu;

import com.usu.showyourwork.Triangle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(
                new Point(1,1),
                new Point(2,2),
                new Point(2,1)
        );

        System.out.println(triangle.getWidth());
    }

    private static void debugLog(Object value) {
        System.out.println("DEBUG: " + value);
    }

    private static void doubleInt(Integer value) {
        value *= 2;
    }
}
