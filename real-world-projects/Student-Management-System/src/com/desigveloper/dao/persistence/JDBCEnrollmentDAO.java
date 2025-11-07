package com.desigveloper.dao.persistence;

import com.desigveloper.model.Enrollment;
import com.desigveloper.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCEnrollmentDAO {
    private Map<String, Enrollment> enrollments = new HashMap<>();
    private Map<String, List<String>> studentEnrollments = new HashMap<>(); // studentId -> list of enrollments
    private Map<String, List<String>> courseEnrollments = new HashMap<>(); // courseId -> list od enrollments
    private static JDBCEnrollmentDAO instance;

    //private JDBCEnrollmentDAO(){}

    public static JDBCEnrollmentDAO getInstance() {
        if (instance == null) instance = new JDBCEnrollmentDAO();
        return instance;
    }

    // Create
    public void addEnrollment(Enrollment enrollment) {
        enrollments.put(enrollment.getId(), enrollment);

        // Update student enrollments
        studentEnrollments
                .computeIfAbsent(enrollment.getStudentId(), k -> new ArrayList<>())
                .add(enrollment.getId());

        // Update course enrollments
        courseEnrollments
                .computeIfAbsent(enrollment.getCourseId(), k -> new ArrayList<>())
                .add(enrollment.getId());
    }

    // Read
    public Enrollment getEnrollment(String enrollmentId) {
        return enrollments.get(enrollmentId);
    }

    public List<Enrollment> getAllEnrollments() {
        return  new ArrayList<>(enrollments.values());
    }

    public List<Enrollment> getEnrollmentByStudent(String studentId) {
        List<String> enrollmentIds = studentEnrollments.getOrDefault(studentId, new ArrayList<>());
        
        List<Enrollment> result = new ArrayList<>();

        for (String id : enrollmentIds) {
            result.add(enrollments.get(id));
        }
        return result;
    }

    public List<Enrollment> getEnrollmentByCourse(String courseId) {
        List<String> enrollmentIds = courseEnrollments.getOrDefault(courseId, new ArrayList<>());

        List<Enrollment> result = new ArrayList<>();

        for (String id : enrollmentIds) {
            result.add(enrollments.get(id));
        }
        return result;
    }

    // Update
    public void updateEnrollment(Enrollment enrollment) {
        if (enrollmentExists(enrollment.getId()))
            enrollments.remove(enrollment.getId());

        enrollments.put(enrollment.getId(), enrollment);
    }

    // Delete
    public void deleteEnrollment(String enrollmentId) {
        Enrollment enrollment = enrollments.get(enrollmentId);

        if (enrollment != null) {
            enrollments.remove(enrollmentId);

            // Remove student from enrollment
            if (studentEnrollments.containsKey(enrollment.getStudentId())) {
                studentEnrollments.get(enrollment.getStudentId()).remove(enrollmentId);
            }

            // Remove course from enrollment
            if (courseEnrollments.containsKey(enrollment.getCourseId())) {
                courseEnrollments.get(enrollment.getCourseId()).remove(enrollmentId);
            }
        }
    }

    // Check if enrollment exists
    public boolean enrollmentExists(String enrollmentId) {
        return enrollments.containsKey(enrollmentId);
    }
}
