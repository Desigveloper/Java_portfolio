package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.dao.StudentDAO;
import com.desigveloper.studentmanagement.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryStudentDaoImp implements StudentDAO {
    private final Map<String, Student> students = new HashMap<>();
    private static MemoryStudentDaoImp instance;

    private MemoryStudentDaoImp() {
        // Private constructor for singleton pattern
    }

    public static MemoryStudentDaoImp getInstance() {
        if (instance == null) {
            instance = new MemoryStudentDaoImp();
        }
        return instance;
    }

    // Interfaces implementation
    // Create
    @Override
    public void create(Student student) {
        students.put(student.getId(), student);
    }

    // Read
    @Override
    public Optional<Student> get(String studentId) {
        return Optional.ofNullable(students.get(studentId));
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }

    // Update
    @Override
    public void update(Student student) {
        if (studentsExists(student.getId()))
            students.put(student.getId(), student);
    }

    // Delete
    @Override
    public void delete(Student student) {
        students.remove(student.getId());
    }

    @Override
    public List<Student> findByMajor(String major) {
        return students.values().stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    // Additional helper method - Check if student exists
    public boolean studentsExists(String studentId) {
        return students.containsKey(studentId);
    }
}
