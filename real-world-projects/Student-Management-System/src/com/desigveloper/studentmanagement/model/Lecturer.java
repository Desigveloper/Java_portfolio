package com.desigveloper.studentmanagement.model;

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

    // Static builder method
    public static Builder builder(String id, String name, String email) {
        return new Builder(id, name, email);
    }

    // Static builder class
    public static class Builder {
        private String lecturerId;
        private String name;
        private String email;
        private String department;

        public Builder(String lecturerId, String name, String email) {
            this.lecturerId = lecturerId;
            this.name = name;
            this.email = email;
        }

        public Builder withDepartment(String department) {
            this.department = department;
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
