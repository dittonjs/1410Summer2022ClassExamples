package com.usu;

import java.util.ArrayList;

public class School {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }

    public static Student findStudentByName(String name) {
        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).getName().equals(name)) {
                return students.get(i);
            }
        }
        return null;
    };

    public static Course findCourseByName(String name) {
        for (int i = 0; i < courses.size(); i ++) {
            if (courses.get(i).getName().equals(name)) {
                return courses.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }
}
