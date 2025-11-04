package com.desigveloper.dao;

import com.desigveloper.model.Student;

import java.util.List;

public interface StudentDAO extends BaseDAO<Student> {
    // Additional method specific to student can be added here
    // For example, find by major
    List<Student> findByMajor(String major);
}
