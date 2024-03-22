package com.AnywareSoftware.StudentManagementSystem.daos;

import com.AnywareSoftware.StudentManagementSystem.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TeacherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(teacher);
    }

    public Teacher getTeacherById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    public List<Teacher> getAllTeachers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Teacher", Teacher.class).list();
    }
}
