package com.desigveloper.dao.persistence;

import com.desigveloper.dao.StudentDAO;
import com.desigveloper.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCStudentDAO {
    private Map<String, Student> students = new HashMap<>();
    private static JDBCStudentDAO instance;

    public JDBCStudentDAO() {
        // Private constructor for singleton pattern
    }

    public static JDBCStudentDAO getInstance() {
        if (instance == null) {
            instance = new JDBCStudentDAO();
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
