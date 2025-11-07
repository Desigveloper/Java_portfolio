package com.desigveloper.dao.persistence;

import com.desigveloper.model.Student;

public class SampleDataGenerator {
    public void generateSampleData() {
        // JDBC DAO instance
        JDBCStudentDAO persistStudentDao = new JDBCStudentDAO();
        JDBCLecturerDAO persistLecturerDao = new JDBCLecturerDAO();
        JDBCCourseDAO persistCourseDao = new JDBCCourseDAO();
        JDBCEnrollmentDAO persistEnrollmentDao = new JDBCEnrollmentDAO();

        // Sample students
        Student student = Student.builder("S001", )
        persistStudentDao.addStudent();
        
    }
}
