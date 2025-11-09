package com.desigveloper.studentmanagement.dao.inmemory.list;

import com.desigveloper.studentmanagement.dao.LecturerDAO;
import com.desigveloper.studentmanagement.model.Lecturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryLecturerDaoList implements LecturerDAO {
    private List<Lecturer> lecturers = new ArrayList<>();

    @Override
    public Optional<Lecturer> get(String lecturerId) {
        return lecturers.stream()
                .filter(lecturer -> lecturer.getId().equals(lecturerId))
                .findFirst();
    }

    @Override
    public List<Lecturer> getAll() {
        return new ArrayList<>(lecturers);
    }

    @Override
    public void create(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    @Override
    public void update(Lecturer lecturer) {
        // In real-application, we would update existing lecturer in database
        // For in-memory, we would delete old lecturer and save the update one
        delete(lecturer);
        create(lecturer);
    }

    @Override
    public void delete(Lecturer lecturer) {
        lecturers.removeIf(t -> t.getId().equals(lecturer.getId()));
    }

    @Override
    public List<Lecturer> findByDepartment(String department) {
        return lecturers.stream()
                .filter(lecturer -> lecturer.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }
}
