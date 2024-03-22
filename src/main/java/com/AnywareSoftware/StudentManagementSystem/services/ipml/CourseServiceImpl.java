package com.AnywareSoftware.StudentManagementSystem.services.ipml;

import com.AnywareSoftware.StudentManagementSystem.entities.Course;
import com.AnywareSoftware.StudentManagementSystem.daos.CourseDAO;
import com.AnywareSoftware.StudentManagementSystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public Course createCourse(Course course) {
        courseDAO.saveCourse(course);
        return course; // Optional: return the saved course
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseDAO.getCourseById(id);
        if (existingCourse != null) {
            course.setId(existingCourse.getId());
            courseDAO.updateCourse(course);
            return course; // Optional: return the updated course
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseDAO.getCourseById(id);
        if (course != null) {
            courseDAO.deleteCourse(course);
        }
    }
}
