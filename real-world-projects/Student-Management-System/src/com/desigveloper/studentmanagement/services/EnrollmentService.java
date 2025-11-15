package com.desigveloper.studentmanagement.services;

import com.desigveloper.studentmanagement.dao.EnrollmentDAO;
import com.desigveloper.studentmanagement.dao.inmemory.MemoryEnrollmentDaoImp;
import com.desigveloper.studentmanagement.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EnrollmentService {
    private final EnrollmentDAO enrollmentDao;

    public EnrollmentService() {
        this.enrollmentDao = MemoryEnrollmentDaoImp.getInstance();
    }

    // For switching implementation
    public EnrollmentService(EnrollmentDAO enrollmentDao) {
        this.enrollmentDao = enrollmentDao;
    }

    public boolean addEnrollment(Enrollment enrollment) {
        // Check if enrollment exists
        if (enrollmentDao.get(enrollment.getId()).isPresent()) {
            throw new IllegalArgumentException("Enrollment with ID: " + enrollment.getId() + " already exists.");
        }

        // Check if student is already enrolled
        // Depends on business rules but assuming we don't duplicate enrollments for same student
        // in same semester
        String studentId = enrollment.getStudentId();
        String courseId = enrollment.getCourseId();
        Optional<Enrollment> existing = enrollmentDao.findByStudentAndCourse(studentId, courseId);
        if (existing.isPresent() && Objects.equals(existing.get().getSemester(), enrollment.getSemester())) {
            throw new IllegalArgumentException("Student is already for this course in this semester");
        }
        enrollmentDao.create(enrollment);
        return true;
    }

    public Optional<Enrollment> getEnrollment(String enrollmentId) {
        return enrollmentDao.get(enrollmentId);
    }

    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollmentDao.getAll());
    }

    public List<Enrollment> getEnrollmentBySemester(int semester) {
        return new ArrayList<>(enrollmentDao.findBySemester(semester));
    }

    public List<Enrollment> getEnrollmentByStudentId(String studentId) {
        return new ArrayList<>(enrollmentDao.findByStudentId(studentId));
    }

    public List<Enrollment> getEnrollmentByCourseId(String courseId) {
        return new ArrayList<>(enrollmentDao.findByCourseId(courseId));
    }

    public Optional<Enrollment> getEnrollmentByStudentAndCourse(String studentId, String courseId) {
        return enrollmentDao.findByStudentAndCourse(studentId, courseId);
    }

    public void updateEnrollment(String enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentDao.get(enrollmentId);
        if (enrollment.isEmpty()) {
            throw new IllegalArgumentException("Enrollment with ID: " + enrollmentId + " does not exist.");
        }
        enrollmentDao.update(enrollment.get());
    }

    public  void updateEnrollmentGrade(String enrollmentId, String grade) {
        Optional<Enrollment> enrollmentOpt = enrollmentDao.get(enrollmentId);

        if (enrollmentOpt.isPresent()) {
            Enrollment enrollment = enrollmentOpt.get();
            enrollment.setGrade(grade);
            enrollmentDao.update(enrollment);
        } else {
            throw new IllegalArgumentException("Enrollment with ID: " + enrollmentId + " does not exist.");
        }
    }
    public boolean dropEnrollment(String enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentDao.get(enrollmentId);
        if (enrollment.isEmpty())
            return false; // Enrollment with Id not found

        enrollmentDao.delete(enrollment.get());
        return true;
    }
}
