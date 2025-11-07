package com.desigveloper.studentmanagement.model;


public class Course {
    private final String courseCode;
    private final String title;
    private final int credit;
    private final String prerequisite;
    private final int capacity;
    private final String lecturerId;

    private Course(Builder builder) {
        this.courseCode = builder.courseCode;
        this.title = builder.title;
        this.credit = builder.credits;
        this.prerequisite = builder.prerequisite;
        this.capacity = builder.capacity;
        this.lecturerId = builder.lecturerId;
    }

    // Getters
    public String getId() {
        return this.courseCode;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCredits() {
        return this.credit;
    }

    public String checkPrerequisite() {
        return this.prerequisite;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    @Override
    public String toString() {
        return "Course{code= '%s' title='%s' credits='%d' prerequisite='%s', capacity='%d'"
                .formatted(courseCode, title, credit, prerequisite, capacity);
    }

    // Static builder method
    public static Builder builder(String code, String title, int credit) {
        return new Builder(code, title, credit);
    }

    // Static Builder class
    public static class Builder {
        private String courseCode;
        private String title;
        private int credits;
        private String prerequisite;
        private int capacity;
        private String lecturerId;

        public Builder(String courseCode, String title, int credits) {
            this.courseCode = courseCode;
            this.title = title;
            this.credits = credits;
        }

        public Builder withLecturerId(String lecturerId) {
            this.lecturerId = lecturerId;
            return  this;
        }
        public Builder withPrerequisite(String prerequisite) {
            this.prerequisite = prerequisite;
            return this;
        }

        public Builder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
        
    }


    public void addStudent(Student student) {

    }

    public void removeStudent(Student student) {

    }

    public void updateInfo() {

    }
    // departmentSchedule
}
