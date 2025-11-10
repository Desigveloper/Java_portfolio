package com.desigveloper.studentmanagement.services;

import com.desigveloper.studentmanagement.dao.CourseDAO;
import com.desigveloper.studentmanagement.dao.inmemory.MemoryCourseDaoImp;
import com.desigveloper.studentmanagement.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseService {
    private final CourseDAO courseDao;

    public CourseService() {
        this.courseDao = MemoryCourseDaoImp.getInstance();
    }

    // For switching implementations
    public CourseService(CourseDAO courseDao) {
        this.courseDao = courseDao;
    }

    public void addCourse(Course course) {
        if (courseDao.get(course.getId()).isPresent()) {
            throw new IllegalArgumentException("Course with ID: " + course.getId() + " already exists.");
        }
        courseDao.create(course);
    }

    public Optional<Course> getCourse(String courseCode) {
        return courseDao.get(courseCode);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courseDao.getAll());
    }

    public List<Course> getCourseByLecturerId(String lecturerId) {
        return new ArrayList<>(courseDao.findByLecturerId(lecturerId));
    }

    public void updateCourse(Course course) {
        if (courseDao.get(course.getId()).isEmpty()) {
            throw new IllegalArgumentException("Course with ID: " + course.getId() + " does not exist.");
        }
        courseDao.update(course);
    }

    public void deleteCourse(Course course) {
        courseDao.delete(course);
    }
}
