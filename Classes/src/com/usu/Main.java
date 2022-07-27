package com.usu;

import com.usu.person.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[10];
        for (int i = 0; i < people.length; i ++) {
            people[i] = new Person("Person " + i, Person.Role.ADMIN);
            System.out.println(people[i].getRole());
            System.out.println(Person.getNumPeople());
        }

        System.out.println(Person.getNumPeople());

        for (Person person: people) {
            person.setName("Person Modified");
            System.out.println(person.getName());
        }
        // write your code here
    }

    public static void enrollAllInCourse(Person[] people, String course) {
        for (Person person: people) {
            person.setName("asdfl;kj");
            person.enrollInCourse(course);
        }
    }
}
