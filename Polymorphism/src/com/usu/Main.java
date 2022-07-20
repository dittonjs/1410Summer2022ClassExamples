package com.usu;

public class Main {

    public static void main(String[] args) {
	    // write your code here
//        reportStudent(new ElementarySchoolStudent("Joseph", 'A'));
//        reportStudent(new ElementarySchoolStudent("Sophie", 'B'));
//        reportStudent(new HighSchoolStudent("Catelyn", 'C'));
//        reportStudent(new Student("Josh", 'D'));

        Student a = new HighSchoolStudent("asdf", 'A');
        reportStudent(a);
        changeNameToBob(a);
        reportStudent(a);
        a = new ElementarySchoolStudent("qw3er", 'a');

        //... program does stuff

    }

    public static void changeNameToBob(Person person) {
        person.setName("Bob");
    }

    public static void reportStudent(Student student) {
        if (student instanceof ElementarySchoolStudent) {
            ElementarySchoolStudent s = (ElementarySchoolStudent)student;
            System.out.println(s.getTeacherName());
        }
        System.out.println(student);
    }
}


class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return String.format("Person name: %15s", name);
    }
}

class Student extends Person {
    private char grade;
    public Student(String name, char grade) {
        super(name);
        this.grade = grade;
    }

    public char getGrade() {
        return grade;
    };

    @Override
    public String toString() {
        return String.format("%s\nGrade: %15s", super.toString(), getGrade());
    }

    public String getTeacherName() {
        return "Ms. Teacher";
    }
}

class ElementarySchoolStudent extends Student {
    public ElementarySchoolStudent(String name, char grade) {
        super(name, grade);
    }
}

class HighSchoolStudent extends Student {
    public HighSchoolStudent(String name, char grade) {
        super(name, grade);
    }
}
