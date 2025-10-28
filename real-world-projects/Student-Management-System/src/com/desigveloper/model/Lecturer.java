package com.desigveloper.model;

public class Lecturer {
    private final String lecturerId;
    private final String name;
    private final String email;
    private final String department;

    private Lecturer(Builder builder) {
        this.lecturerId = builder.lecturerId;
        this.name = builder.name;
        this.email = builder.email;
        this.department = builder.department;
    }

    // Getters
    public String getlecturerId() {
        return this.lecturerId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDepartment() {
        return this.department;
    }

    // Static builder class
    public static class Builder {
        private String lecturerId;
        private String name;
        private String email;
        private String department;

        public Builder(String lecturerId, String name, String department) {
            this.lecturerId = lecturerId;
            this.name = name;
            this.department = department;
        }

        Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }
        
    }

    public void viewAssignedCourses(Course[] course) {
        
    }

    public void assignGrade() {

    }
}
