package com.example.parta;

public class Student {
    private String name;
    private Course course;

    public Student() {
        // default constructor for Spring
    }

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
