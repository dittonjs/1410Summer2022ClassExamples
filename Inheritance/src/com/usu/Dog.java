package com.usu;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Dog extends Animal {

    public Dog(@NotNull String name) {
        super(name);
    }

    public void sniff() {
        System.out.println("IM SNIFFIN!");
    }

    @Override
    public void makeSound() {
        System.out.println("I am a dog!");
    }
}
