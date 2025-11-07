package com.desigveloper.studentmanagement.model;

import java.time.LocalDate;

public class Student extends Person {

    private final LocalDate birthDate;
    private final String enrollmentStatus;
    private final String major;
    private final String studentGPA;

    private Student(Builder builder) {
        super(builder.studentId, builder.name, builder.email);
        this.birthDate = builder.birthDate;
        this.major = builder.major;
        this.enrollmentStatus = builder.enrollmentStatus;
        this.studentGPA = builder.studentGPA;
    } 

    //Getters only
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String getEnrollmentStatus() {
        return this.enrollmentStatus;
    }

    public String getMajor() {
        return this.major;
    }

    public String getGPA() {
        return this.studentGPA;
    }

    @Override
    public String toString() {
        return "Student{id= '%s' name='%s' email='%s' major='%s', DOB='%s' enrollment status='%s' GPA='%s'"
                .formatted(getId(), getName(), getEmail(), major, birthDate, enrollmentStatus, studentGPA);
    }

    // static builder method
    public static Builder builder(String id, String name, LocalDate birthDate) {
        return new Builder(id, name, birthDate);
    }

    // Builder class
    public static class Builder {
        private String studentId;
        private  String name;
        private LocalDate birthDate;
        private String major;
        private String enrollmentStatus;
        private String studentGPA;
        private String email;

        public Builder(String studentId, String name, LocalDate birthDate) {
            this.name = name;
            this.studentId = studentId;
            this.birthDate = birthDate;
        }

        public Builder withMajor(String major) {
            this.major = major;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withEnrolledCourse(String enrollmentStatus) {
            this.enrollmentStatus = enrollmentStatus;
            return this;
        }

        public Builder withStudentGPA(String studentGPA) {
            this.studentGPA = studentGPA;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
        
    }

    public void enroll(Course course) {
        
    }

    public void updateProfile() {
        
    }

    public void viewGrades() {

    }

    public double calculateGPA() {
        return 0;
    }

    public void dropCourse(Course course) {

    }

    public void viewSchedule() {
        
    }

}
