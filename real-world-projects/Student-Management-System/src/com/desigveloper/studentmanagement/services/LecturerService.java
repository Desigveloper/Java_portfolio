package com.desigveloper.studentmanagement.services;

import com.desigveloper.studentmanagement.dao.LecturerDAO;
import com.desigveloper.studentmanagement.dao.inmemory.MemoryLecturerDaoImp;
import com.desigveloper.studentmanagement.model.Lecturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LecturerService {
    private final LecturerDAO lecturerDao;

    public LecturerService() {
        this.lecturerDao = MemoryLecturerDaoImp.getInstance();
    }

    // For switching implementations
    public LecturerService(LecturerDAO lecturerDao) {
        this.lecturerDao = lecturerDao;
    }

    public void addLecturer(Lecturer lecturer) {
        // Check if lecturer exists
        if (lecturerDao.get(lecturer.getId()).isPresent()) {
            throw new IllegalArgumentException("Lecturer with ID: " + lecturer.getId() + " already exists");
        }
        lecturerDao.create(lecturer);
    }

    public Optional<Lecturer> getLecturer(String lecturerId) {
        return lecturerDao.get(lecturerId);
    }

    public List<Lecturer> getAllLecturers() {
        return new ArrayList<>(lecturerDao.getAll());
    }

    public List<Lecturer> getLecturerByDepartment(String department) {
        return new ArrayList<>(lecturerDao.findByDepartment(department));
    }

    public void updateLecturer(Lecturer lecturer) {
        if (lecturerDao.get(lecturer.getId()).isEmpty()) {
            throw new IllegalArgumentException("Lecturer with ID: " + lecturer.getId() + " does not exist.");
        }
        lecturerDao.update(lecturer);
    }

    public void deleteLecturer(Lecturer lecturer) {
        lecturerDao.delete(lecturer);
    }
}
