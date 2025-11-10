package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.dao.EnrollmentDAO;
import com.desigveloper.studentmanagement.model.Enrollment;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryEnrollmentDaoImp implements EnrollmentDAO {
    private final Map<String, Enrollment> enrollments = new HashMap<>();
    private final Map<String, List<String>> studentEnrollments = new HashMap<>(); // studentId -> list of enrollments
    private final Map<String, List<String>> courseEnrollments = new HashMap<>(); // courseId -> list od enrollments
    private static MemoryEnrollmentDaoImp instance;

    private MemoryEnrollmentDaoImp() {
        // Private constructor for singleton pattern
    }

    public static MemoryEnrollmentDaoImp getInstance() {
        if (instance == null) instance = new MemoryEnrollmentDaoImp();
        return instance;
    }

    // Interface implementations
    // Create
    @Override
    public void create(Enrollment enrollment) {
        enrollments.put(enrollment.getId(), enrollment);

        // Update enrollment indices
        // student enrollments
        studentEnrollments
                .computeIfAbsent(enrollment.getStudentId(), k -> new ArrayList<>())
                .add(enrollment.getId());

        // course enrollments
        courseEnrollments
                .computeIfAbsent(enrollment.getCourseId(), k -> new ArrayList<>())
                .add(enrollment.getId());
    }

    // Read
    @Override
    public Optional<Enrollment> get(String enrollmentId) {
        return Optional.ofNullable(enrollments.get(enrollmentId));
    }

    @Override
    public List<Enrollment> getAll() {
        return  new ArrayList<>(enrollments.values());
    }

    @Override
    public List<Enrollment> findByStudentId(String studentId) {
        List<String> enrollmentIds = studentEnrollments.getOrDefault(studentId, new ArrayList<>());
        
        List<Enrollment> result = new ArrayList<>();
        for (String id : enrollmentIds) {
            result.add(enrollments.get(id));
        }
        return result;
    }

    @Override
    public List<Enrollment> findByCourseId(String courseId) {
        List<String> enrollmentIds = courseEnrollments.getOrDefault(courseId, new ArrayList<>());

        List<Enrollment> result = new ArrayList<>();
        for (String id : enrollmentIds) {
            result.add(enrollments.get(id));
        }
        return result;
    }

    @Override
    public List<Enrollment> findBySemester(int semester) {
        return enrollments.values().stream()
                .filter(enrollment -> enrollment.getSemester() == semester)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Enrollment> findByStudentAndCourse(String studentId, String courseId) {
        return enrollments.values().stream()
                .filter(enrollment -> enrollment.getStudentId().equals(studentId)
                    && enrollment.getCourseId().equals(courseId))
                .findFirst();
    }

    // Update
    @Override
    public void update(Enrollment enrollment) {
        if (enrollmentExists(enrollment.getId()))
            enrollments.put(enrollment.getId(), enrollment);
    }

    // Delete
    @Override
    public void delete(Enrollment enrollment) {
        String enrollmentId = enrollment.getId();
        Enrollment existing = enrollments.get(enrollmentId);

        if (existing != null) {
            enrollments.remove(enrollmentId);

            // Remove relationship indices
            // Remove student from enrollment
            if (studentEnrollments.containsKey(enrollmentId)) {
                studentEnrollments.get(enrollment.getStudentId()).remove(enrollmentId);
            }

            // Remove course from enrollment
            if (courseEnrollments.containsKey(enrollment.getCourseId())) {
                courseEnrollments.get(enrollment.getCourseId()).remove(enrollmentId);
            }
        }
    }

    // Addition helper method - Checks if enrollment exists
    public boolean enrollmentExists(String enrollmentId) {
        return enrollments.containsKey(enrollmentId);
    }
}
