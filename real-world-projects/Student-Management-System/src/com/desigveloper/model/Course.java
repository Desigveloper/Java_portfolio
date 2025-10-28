package com.desigveloper.model;

public class Course {
    private String courseId;
    private String title;
    private byte credits;

    public Course(String courseId, String title, byte credits) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
    }

    // Getters
    public String getCourseId() {
        return this.courseId;
    }

    public String getTitle() {
        return this.title;
    }

    public byte getCredits() {
        return this.credits;
    }


    public void remove(Student student) {

    }

    // departmentSchedule
}
