package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.dao.StudentDAO;
import com.desigveloper.studentmanagement.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryStudentDAO implements StudentDAO {
    private List<Student> students = new ArrayList<>();

    @Override
    public Optional<Student> get(String studentId) {
        return students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst();
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void create(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student) {
        // In real-application, we would update existing student in database
        // For in-memory, we would delete old student and save the update one
        delete(student);
        create(student);
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }

    @Override
    public List<Student> findByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }
}
