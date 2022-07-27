package com.usu;

import java.util.ArrayList;

public class Course {
    private static int generatedIdCount = 0;
    private String name;
    private int id;
    private ArrayList<Student> students = new ArrayList<>();
    public Course() {
        this("Default name");
    }

    public Course(String name) {
        this(name, generatedIdCount++);
    }

    public Course(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student students) {
        this.students.add(students);
    }

    public void addStudent(String name) {
        Student student = School.findStudentByName(name);
        if (student != null) {
            addStudent(student);
        }
    }
}
