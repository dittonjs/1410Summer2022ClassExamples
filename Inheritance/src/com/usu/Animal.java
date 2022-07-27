package com.usu;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Animal {
    private String name;
    public Animal(@NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println("I am an animal");
    }

    @Override
    public String toString() {
        return "Animal: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Animal) {
            Animal otherAnimal = (Animal) o;
            return otherAnimal.getName().equals(name);
        }
        return false;
    }
}
