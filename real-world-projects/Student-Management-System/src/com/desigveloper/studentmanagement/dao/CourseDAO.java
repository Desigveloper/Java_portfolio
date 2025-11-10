package com.desigveloper.studentmanagement.dao;

import com.desigveloper.studentmanagement.model.Course;

import java.util.List;

public interface CourseDAO extends BaseDAO<Course>{
    // Additional method specific to courses can be added here
    List<Course> findByLecturerId(String courseCode);
}
