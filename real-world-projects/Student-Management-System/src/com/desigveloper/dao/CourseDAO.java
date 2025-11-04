package com.desigveloper.dao;

import com.desigveloper.model.Course;

import java.util.List;

public interface CourseDAO extends BaseDAO<Course>{
    // Additional method specific to courses can be added here
    List<Course> findByCode(String courseCode);
}
