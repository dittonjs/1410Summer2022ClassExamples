package com.usu;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
	    // write your code here
        Rattlesnake animal = new Rattlesnake();
        Dog dog = new Dog();
        Robot robot = new Robot();
        moveTheThing(dog);
        moveTheThing(robot);
        moveTheThing(animal);
    }

    public static void moveTheThing(Moveable moveable) {
        System.out.println("Moved thing");
        moveable.move();
    }
}

interface Moveable {
    void move();
}

interface Walkable {
    void walk();
}

interface OtherMovable {
    void move();
}

interface Soundable {
   void makeSound();
}

class Robot implements Walkable, Moveable, Soundable {
    @Override
    public void move() {
        System.out.println("CHUNK CHUNK");
    }

    @Override
    public void makeSound() {
        System.out.println("BZRRRT");
    }
}

abstract class Animal implements Moveable, Soundable, OtherMovable {
    private String name;
    public abstract void eat();
}

abstract class Snake extends Animal {
    @Override
    final public void move() {
        System.out.println("Im slitherin");
    }
}

class Rattlesnake extends Snake {
    @Override
    public void eat() {
        System.out.println("I eat rats");
    }

    @Override
    public void makeSound() {
        System.out.println("*Rattle rattle rattle*");
    }
}

class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("Running on four legs");
    }

    @Override
    public void makeSound() {
        System.out.println("Arf!");
    }

    @Override
    public void eat() {
        System.out.println("I eat meat!");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("Flappin my wings");
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet!");
    }

    @Override
    public void eat() {
        System.out.println("I eat bugs!");
    }
}