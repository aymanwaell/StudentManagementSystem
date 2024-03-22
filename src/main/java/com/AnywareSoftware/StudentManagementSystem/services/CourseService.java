package com.AnywareSoftware.StudentManagementSystem.services;

import com.AnywareSoftware.StudentManagementSystem.entities.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}
