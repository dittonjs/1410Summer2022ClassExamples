package com.usu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Comparable> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student((int)(Math.random() * 30) + 8));
        }

        ArrayList<Comparable> submissions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            submissions.add(new AssignmentSubmission((int)(Math.random() * 101)));
        }

        sort(students);
        sort(submissions);
        displayStudents(students);

        displayStudents(submissions);
    }

    public static void displayStudents(ArrayList students) {
        students.forEach(student -> System.out.println(student));
    }

    public static void sort(ArrayList<Comparable> objects) {
        for (int i = 0; i < objects.size(); i++) {
            int smallest = i;
            for(int j = i+1; j < objects.size(); j++) {
                if (objects.get(j).compareTo(objects.get(smallest)) <= 0) {
                    smallest = j;
                }
            }

            Comparable temp = objects.get(i);
            objects.set(i, objects.get(smallest));
            objects.set(smallest, temp);
        }
    }
}

class AssignmentSubmission implements Comparable {
    private int score;
    public AssignmentSubmission(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof AssignmentSubmission)) {
            throw new RuntimeException("Object is not assignment submission");
        }
        AssignmentSubmission other = (AssignmentSubmission) o;
        return this.score - other.score;
    }

    @Override
    public String toString() {
        return "AssignmentSubmission{" +
                "score=" + score +
                '}';
    }
}

class Student implements Comparable {
    private int age;
    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student)) {
            throw new RuntimeException("Object is not a student");
        }
        Student other = (Student) o;
        return this.age - other.age;
    }
}
