package com.desigveloper.studentmanagement.dao.persistence;

import com.desigveloper.studentmanagement.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class JDBCCourseDAO {
    private Map<String, Course> courses = new HashMap<>();
    private static JDBCCourseDAO instance;

    public static JDBCCourseDAO getInstance() {
        if (instance == null)
            instance = new JDBCCourseDAO();
        return instance;
    }

    // Create
    public void addCourse(Course course) {
        courses.put(course.getId(), course);
    }

    // Read
    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    // Update
    public void updateLecture(Course course) {
        if (courseExists(course.getId()))
            courses.remove(course.getId());

        courses.put(course.getId(), course);
    }

    // Delete
    public void deleteLecturer(Course course) {
        courses.remove(course.getId());
    }

    // Check if lecturer exists
    public boolean courseExists(String lecturerId) {
        return courses.containsKey(lecturerId);
    }
}
