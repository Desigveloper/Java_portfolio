package com.desigveloper.studentmanagement.model;

public class Enrollment {
    private final String enrollmentId;
    private final String studentId;
    private final String courseId;
    private String grade;
    private final Integer semester;
    private final String status;
    private final String date;

    private Enrollment(Builder builder) {
        this.enrollmentId = builder.enrollmentId;
        this.studentId = builder.studentId;
        this.courseId = builder.courseId;
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

    public void setGrade(String grade) {
        this.grade = grade;
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
    
    public String getDate() {
        return this.date;
    }


    @Override
    public String toString() {
        return "Enrollment{id= '%s' Student id='%s' course id='%s' grade='%s', semester='%d' status='%s' date='%s'"
                .formatted(enrollmentId, studentId, courseId, grade, semester, status, date);
    }

    // Static builder method
    public static Builder builder(String enrollmentId, String studentId, String courseId) {
        return new Builder(enrollmentId, studentId, courseId);
    }

    // Static builder class
    public static class Builder {
        private String enrollmentId;
        private String studentId;
        private String courseId;
        private Integer semester;
        private String status;
        private String date;

        public Builder (String enrollmentId, String studentId, String courseId) {
            this.enrollmentId = enrollmentId;
            this.studentId = studentId;
            this.courseId = courseId;
        }

        public Builder withSemester(int semester) {
            this.semester = semester;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withEnrollmentDate(String date) {
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
