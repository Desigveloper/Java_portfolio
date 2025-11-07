package com.desigveloper.services;

import com.desigveloper.model.Lecturer;
import com.desigveloper.model.Student;
import com.desigveloper.model.Course;

public class Admin {
    private final String adminID;
    private final String department;
    private final String permission;
    private final String accessLevel;

    private Admin(Builder builder) {
        this.adminID = builder.adminID;
        this.department = builder.department;
        this.permission = builder.permission;
        this.accessLevel = builder.accessLevel;
    }
    
// Getters
    public String getAdminID() {
        return this.adminID;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getPermission() {
        return this.permission;
    }

    public String getAccessLevel() {
        return this.accessLevel;
    }
    
    public static class Builder {
        private String adminID;
        private String department;
        private String permission;
        private String accessLevel;

        public Builder(String adminID, String department, String permission) {
            this.adminID = adminID;
            this.department = department;
            this.permission = permission;
        }
        public Builder withAccessLevel(String accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }
        
        public Admin build() {
            return new Admin(this);
        }
    }  

    public void addStudent(Student student) {

    }

    public void removeStudent(Student student) {

    }

    public void createStudent(Student student) {

    }

    public void deleteStudent(Student student) {

    }




    public void viewAllStudents() {

    }

    public void addCourse(Course course) {

    }

    public void deleteCourse(Course course) {

    }

    public void viewAllCourses() {
        
    }

    public void addLecturer(Lecturer lecturer) {

    }

    public void removeLecturer(Lecturer lecturer) {

    }

    public void viewAllLecturers() {

    }
}
