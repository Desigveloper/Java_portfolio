package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.dao.EnrollmentDAO;
import com.desigveloper.studentmanagement.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryEnrollmentDAO implements EnrollmentDAO {
    private List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public Optional<Enrollment> get(String enrollmentId) {
        return enrollments.stream()
                .filter(enrollment -> enrollment.getId().equals(enrollmentId))
                .findFirst();
    }

    @Override
    public List<Enrollment> getAll() {
        return new ArrayList<>(enrollments);
    }

    @Override
    public List<Enrollment> findByStudentId(String studentId) {
        return enrollments.stream()
                .filter(enrollment-> enrollment.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Enrollment> findByCourseId(String courseId) {
        return enrollments.stream()
                .filter(enrollment -> enrollment.getCourseId().equals(courseId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Enrollment> findBySemester(int semester) {
        return enrollments.stream()
                .filter(enrollment -> enrollment.getSemester().equals(semester))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Enrollment> findByStudentAndCourse(String studentId, String courseId) {
        return enrollments.stream()
                .filter(enrollment -> enrollment.getStudentId().equals(studentId) &&
                        enrollment.getCourseId().equals(courseId))
                .findFirst();
    }

    @Override
    public void create(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    @Override
    public void update(Enrollment enrollment) {
        // In real-application, we would update existing enrollment in database
        // For in-memory, we would delete old enrollment and save the updated one
        delete(enrollment);
        create(enrollment);
    }


    @Override
    public void delete(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }
}
