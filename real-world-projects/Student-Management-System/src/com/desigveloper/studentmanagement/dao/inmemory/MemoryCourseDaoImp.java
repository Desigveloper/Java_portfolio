package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.dao.CourseDAO;
import com.desigveloper.studentmanagement.model.Course;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryCourseDaoImp implements CourseDAO {
    private final Map<String, Course> courses = new HashMap<>();
    private static MemoryCourseDaoImp instance;

    private MemoryCourseDaoImp() {
        // Private constructor for singleton pattern
    }

    public static MemoryCourseDaoImp getInstance() {
        if (instance == null)
            instance = new MemoryCourseDaoImp();
        return instance;
    }

    // Interface implementations

    // Create
    @Override
    public void create(Course course) {
        courses.put(course.getId(), course);
    }

    // Read
    @Override
    public Optional<Course> get(String courseCode) {
        return Optional.ofNullable(courses.get(courseCode));
    }

    public List<Course> getAll() {
        return new ArrayList<>(courses.values());
    }

    // Update
    @Override
    public void update(Course course) {
        if (courseExists(course.getId()))
            courses.put(course.getId(), course);

    }

    // Delete
    @Override
    public void delete(Course course) {
        courses.remove(course.getId());
    }

    @Override
    public List<Course> findByLecturerId(String lecturerId) {
        return courses.values().stream()
                .filter(course -> course.getLecturerId().equals(lecturerId))
                .collect(Collectors.toList());
    }

    // Additional helper method - Check if lecturer exists
    public boolean courseExists(String lecturerId) {
        return courses.containsKey(lecturerId);
    }
}
