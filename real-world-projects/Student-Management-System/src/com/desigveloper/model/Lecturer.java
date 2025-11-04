package com.desigveloper.model;

public class Lecturer extends Person{
    private final String department;

    private Lecturer(Builder builder) {
        super(builder.lecturerId, builder.name, builder.email);
        this.department = builder.department;
    }

    // Getters
    public String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return "Lecturer{id= '%s' name='%s' email='%s' department='%s'}"
                .formatted(getId(), getName(), getEmail(), department);
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
