package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.dao.LecturerDAO;
import com.desigveloper.studentmanagement.model.Lecturer;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryLecturerDaoImp implements LecturerDAO {
    private final Map<String, Lecturer> lecturers = new HashMap<>();
    private static MemoryLecturerDaoImp instance;

    private  MemoryLecturerDaoImp() {
        // Private constructor for singleton pattern
    }

    public static MemoryLecturerDaoImp getInstance() {
        if (instance == null)
            instance = new MemoryLecturerDaoImp();
        return instance;
    }

    // Interface implementations
    // Create
    @Override
    public void create(Lecturer lecturer) {
        lecturers.put(lecturer.getId(), lecturer);
    }

    // Read
    public Optional<Lecturer> get(String lecturerId) {
        return Optional.ofNullable(lecturers.get(lecturerId));
    }

    @Override
    public List<Lecturer> getAll() {
        return new ArrayList<>(lecturers.values());
    }

    // Update
    @Override
    public void update(Lecturer lecturer) {
        if (lecturerExists(lecturer.getId()))
            lecturers.put(lecturer.getId(), lecturer);
    }

    // Delete
    @Override
    public void delete(Lecturer lecturer) {
        lecturers.remove(lecturer.getId());
    }

    @Override
    public List<Lecturer> findByDepartment(String department) {
        return lecturers.values().stream()
                .filter(lecturer -> lecturer.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }
    // Additional helper method - Checks if lecturer exists
    public boolean lecturerExists(String lecturerId) {
        return lecturers.containsKey(lecturerId);
    }
}
