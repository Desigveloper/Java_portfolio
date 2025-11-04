package com.desigveloper.dao;

import com.desigveloper.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentDAO extends BaseDAO<Enrollment>{
    // Additional method related to enrollment
    List<Enrollment> findBySemester(int semester);
    List<Enrollment> findStudentId(String studentId);
    List<Enrollment> findByLecturerId(String lecturerId);
    Optional<Enrollment> findByStudentAndCourse(String studentId, String courseId);
}
