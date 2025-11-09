package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.dao.CourseDAO;
import com.desigveloper.studentmanagement.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryCourseDAO implements CourseDAO {
    private List<Course> courses = new ArrayList<>();

    @Override
    public Optional<Course> get(String courseCode) {
        return courses.stream()
                .filter(course -> course.getId().equals(courseCode))
                .findFirst();
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public void create(Course course) {
        courses.add(course);
    }

    @Override
    public void update(Course course) {
        // In real-application, we would update existing Courses in database
        // For in-memory, we would delete old course and save the update one
        delete(course);
        create(course);
    }

    @Override
    public void delete(Course course) {
        courses.removeIf(c -> c.getId().equals(course.getId()));
    }

    @Override
    public List<Course> findByCode(String courseCode) {
        return courses.stream()
                .filter(course -> course.getId().equalsIgnoreCase(courseCode))
                .collect(Collectors.toList());
    }
}
