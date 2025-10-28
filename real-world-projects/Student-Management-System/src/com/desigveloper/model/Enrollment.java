package com.desigveloper.model;

public class Enrollment {
    private final String enrollmentId;
    private final String studentId;
    private final String courseId;
    private final String grade;
    private final byte semester;

    private Enrollment(Builder builder) {
        this.enrollmentId = builder.enrollmentId;
        this.studentId = builder.studentId;
        this.courseId = builder.courseId;
        this.grade = builder.grade;
        this.semester = builder.semester;
    }

    // Getters
    public String getEnrollmentId() {
        return this.enrollmentId;
    }

    public String getGrade() {
        return this.grade;
    }

    public byte getSemester() {
        return this.semester;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    // Static builder class
    public static class Builder {
        private String enrollmentId;
        private String studentId;
        private String courseId;
        private byte semester;
        private String grade;

        Builder (String enrollmentId, String studentId, String courseId) {
            this.enrollmentId = enrollmentId;
            this.studentId = studentId;
            this.courseId = courseId;
        }

        Builder withGrade(String grade) {
            this.grade = grade;
            return this;
        }

        Builder withSemester(byte semester) {
            this.semester = semester;
            return this;
        }

        public Enrollment build() {
            return new Enrollment(this);
        }
    }
}
