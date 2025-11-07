package com.desigveloper.studentmanagement.dao;

import com.desigveloper.studentmanagement.model.Lecturer;

import java.util.List;

public interface LecturerDAO extends BaseDAO<Lecturer>{
    // Additional methods specific to lecturer can be added here
    List<Lecturer> findByDepartment(String department);
}
