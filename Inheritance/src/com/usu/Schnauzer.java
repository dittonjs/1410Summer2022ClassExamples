package com.usu;

public class Schnauzer extends Dog{
    public Schnauzer(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("GRRRRRR.");
        super.makeSound();
    }
}
