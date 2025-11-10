package com.desigveloper.studentmanagement.services;

import com.desigveloper.studentmanagement.dao.StudentDAO;
import com.desigveloper.studentmanagement.dao.inmemory.MemoryStudentDaoImp;
import com.desigveloper.studentmanagement.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentDAO studentdao;

    //Constructor: We can inject the Dao, but for nw we will use Map-based one
    public StudentService() {
        // Using the Map-based implementation
        this.studentdao = MemoryStudentDaoImp.getInstance();
    }

    // If we want to switch implementation we can use this
    public StudentService(StudentDAO studentDAO) {
        this.studentdao = studentDAO;
    }

    // Business logic in methods
    public void addStudent(Student student) {
        // Validation: Checking if student already exist
        if (studentdao.get(student.getId()).isPresent()) {
            throw new  IllegalArgumentException("Student with ID " + student.getId() + " already exists.");
        }
        studentdao.create(student);
    }

    public Optional<Student> getStudent(String studentId) {
        return studentdao.get(studentId);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentdao.getAll());
    }

    public void updateStudent(Student student) {
        if (studentdao.get(student.getId()).isEmpty()) {
            throw new IllegalArgumentException("Student with ID: " + student.getId() + " does not exist.");
        }
        studentdao.update(student);
    }

    public void deleteStudent(Student student) {
        studentdao.delete(student);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentdao.findByMajor(major);
    }
}
