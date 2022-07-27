package com.usu;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for (int i = 0; i < 100; i++) {
            School.addStudent(new Student("Student " + i));
        }

        for (int i = 0; i < 10; i++) {
            School.addCourse(new Course("Course " + i));
        }

        for(Student student : School.getStudents()) {
            System.out.println(student.getName());
        }

        for(Course course : School.getCourses()) {
            System.out.println(course.getName());
        }

        Student student0 = School.findStudentByName("Student 0");
        Course course = School.findCourseByName("Coursekljhasdf");

        if (course != null) {
            course.addStudent("Student 0");
        } else {
            System.out.println("That course doesn't exist");
        }

        MyStringBuilder builder = new MyStringBuilder()
                .append("Hello, world\n")
                .append("How are you?\n")
                .append("Goodbye!\n")
                .append(String.format("%.2f", 3.14234));
        System.out.println(builder.toString());
    }
}
