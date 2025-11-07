package com.desigveloper.dao.persistence;

import com.desigveloper.model.Lecturer;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class JDBCLecturerDAO {
    private Map<String, Lecturer> lecturers = new HashMap<>();
    private static JDBCLecturerDAO instance;

    public static JDBCLecturerDAO getInstance() {
        if (instance == null)
            instance = new JDBCLecturerDAO();
        return instance;
    }

    // Create
    public void addLecturer(Lecturer lecturer) {
        lecturers.put(lecturer.getId(), lecturer);
    }

    // Read
    public Lecturer getLecturer(String lecturerId) {
        return lecturers.get(lecturerId);
    }

    public List<Lecturer> getAllLecturers() {
        return new ArrayList<>(lecturers.values());
    }

    // Update
    public void updateLecture(Lecturer lecturer) {
        if (lecturerExists(lecturer.getId()))
            lecturers.remove(lecturer.getId());

        lecturers.put(lecturer.getId(), lecturer);
    }

    // Delete
    public void deleteLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer.getId());
    }

    // Check if lecturer exists
    public boolean lecturerExists(String lecturerId) {
        return lecturers.containsKey(lecturerId);
    }
}
