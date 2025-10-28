package com.desigveloper.model;

import java.time.LocalDate;

public class Student {
    private final String studentId;
    private final String name;
    private final LocalDate birthDate;
    private final String enrolledCourse;
    private final String major;

    private Student(Builder builder) {
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.studentId = builder.studentId;
        this.major = builder.major;
        this.enrolledCourse = builder.enrolledCourse;
    } 

    //Getters only
    public String getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String getEnrolledCourse() {
        return this.enrolledCourse;
    }

    public String getMajor() {
        return this.major;
    }


    // Builder class
    public static class Builder {
        private String studentId;
        private  String name;
        private LocalDate birthDate;
        private String major;
        private String enrolledCourse;

        public Builder(String studentId, String name, LocalDate birthDate) {
            this.name = name;
            this.studentId = studentId;
            this.birthDate = birthDate;
        }

        Builder withMajor(String major) {
            this.major = major;
            return this;
        }

        Builder withEnrolledCourse(String enrolledCourse) {
            this.enrolledCourse = enrolledCourse;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
        
    }

    public void enrol(Course course) {
        
    }

    public void dropCourse(Course course) {

    }

    public void viewSchedule() {
        
    }

}
