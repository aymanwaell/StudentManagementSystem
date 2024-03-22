package com.AnywareSoftware.StudentManagementSystem.daos;

import com.AnywareSoftware.StudentManagementSystem.entities.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    public void updateCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.update(course);
    }

    public void deleteCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(course);
    }

    public Course getCourseById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    public List<Course> getAllCourses() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Course", Course.class).list();
    }
}
