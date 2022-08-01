package com.usu;

import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

// Course has many students.
// Student takes a course.
// Student has an A#.

public class Main {
    public static void main(String[] args) {
        FeatheredAnimal animal = new FeatheredAnimal();

    }
}

class Animal {
    public String name;
    public void makeSound() {
        System.out.println("I am an animal");
    }

    public Animal() {
        name = "My Name";
        System.out.println("Do I get called?");
    }

    public String getName() {
        return name;
    }

    protected void move() {};
}


class FeatheredAnimal extends Animal {
    private int numFeathers;
    public FeatheredAnimal() {
        super();
        numFeathers = 100;
        System.out.println("What about me?");
        try {

        }
        catch (ArithmeticException ex) {

        }
        catch (Exception ex) {

        } finally {

        }
    }
}
