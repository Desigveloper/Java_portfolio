package com.desigveloper.studentmanagement.dao.inmemory.map;

import com.desigveloper.studentmanagement.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryStudentDaoMap {
    private Map<String, Student> students = new HashMap<>();
    private static MemoryStudentDaoMap instance;

    public MemoryStudentDaoMap() {
        // Private constructor for singleton pattern
    }

    public static MemoryStudentDaoMap getInstance() {
        if (instance == null) {
            instance = new MemoryStudentDaoMap();
        }
        return instance;
    }

    // Create
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    // Read
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // Update
    public void updateStudent(Student student) {
        if (studentsExists(student.getId()))
            deleteStudent(student.getId());

        students.put(student.getId(), student);
    }

    // Delete
    public void deleteStudent(String studentId) {
        students.remove(studentId);
    }

    // Check if student exists
    public boolean studentsExists(String studentId) {
        return students.containsKey(studentId);
    }
}
