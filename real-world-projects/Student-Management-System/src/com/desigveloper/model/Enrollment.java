package com.desigveloper.model;

import java.time.LocalDate;

public class Enrollment {
    private final String enrollmentId;
    private final String studentId;
    private final String courseId;
    private final String grade;
    private final Integer semester;
    private final String status;
    private final LocalDate date;

    private Enrollment(Builder builder) {
        this.enrollmentId = builder.enrollmentId;
        this.studentId = builder.studentId;
        this.courseId = builder.courseId;
        this.grade = builder.grade = "Not grader"; // Default value
        this.semester = builder.semester;
        this.status = builder.status;
        this.date = builder.date;
    }

    // Getters
    public String getId() {
        return this.enrollmentId;
    }

    public String getGrade() {
        return this.grade;
    }

    public Integer getSemester() {
        return this.semester;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public String getCourseId() {
        return this.courseId;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public LocalDate getDate() {
        return this.date;
    }


    @Override
    public String toString() {
        return "Enrollment{id= '%s' Student id='%s' course id='%s' grade='%s', semester='%d' status='%s' date='%s'"
                .formatted(enrollmentId, studentId, courseId, grade, semester, status, date);
    }

    // Static builder class
    public static class Builder {
        private String enrollmentId;
        private String studentId;
        private String courseId;
        private Integer semester;
        private String grade;
        private String status;
        private LocalDate date;

        Builder (String enrollmentId, String studentId, String courseId) {
            this.enrollmentId = enrollmentId;
            this.studentId = studentId;
            this.courseId = courseId;
        }

        Builder withGrade(String grade) {
            this.grade = grade;
            return this;
        }

        Builder withSemester(int semester) {
            this.semester = semester;
            return this;
        }

        Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        Builder withEnrollemntDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Enrollment build() {
            return new Enrollment(this);
        }
    }

    public void recordGrade(double grade) {

    }

    public void updateStatus() {

    }

    public void validateEnrollment(Enrollment enrollment) {
        
    }


}
