package com.usu.person;

public class Person {
    public enum Role {
        ADMIN,
        STUDENT,
        INSTRUCTOR
    }
    final private Identification identification = new Identification();
    private static int numPeople = 0;

    private Role role;
    public Person(String name, Role role) {
        numPeople ++;
        this.role = role;
        setName(name);
    }

    public String getRole() {
        return role.toString();
    }

    public static int getNumPeople() {
        return numPeople;
    }

    public String getName() {
        return identification.getFirstName() + " " + identification.getLastName();
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            System.out.println("Name must have first and last name");
        } else {
            this.identification.setFirstName(parts[0]);
            this.identification.setLastName(parts[1]);
        }
        // enforce a first and last name
    }

    public void enrollInCourse(String courseName) {
        System.out.printf("Person %s was enrolled in %s.\n", identification.getFirstName(), courseName);
    }
}


