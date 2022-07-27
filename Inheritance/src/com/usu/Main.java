package com.usu;

public class Main {
    public static void main(String[] args) {
        String value = "";
        int number = 10;
        Integer number2 = 10;
        Integer value2 = number;

        System.out.println(value2 == number2);

        if (value.equals(new Dog("asdf"))) {

        }
        Animal[] animals = {
                new Dog("Sully"),
                new Dog("Levy"),
                new Bird("Ranni"),
                new Cat("Tobin"),
        };

        Dog[] dogs = {
                new Dog("asdfasdf"),
                new Schnauzer("wsrwer")
        };
//
//        for(Dog dog: dogs) {
//            dog.makeSound();
//        }

//        for (Animal animal : animals) {
//            animal.makeSound();
//        }

        Dog dog = new Dog("asdrf");
        dog.makeSound();
        Animal animal = new Animal("Fred");
        Cat cat = new Cat("Fred");
        System.out.println(animal.equals(cat));
    }


}
