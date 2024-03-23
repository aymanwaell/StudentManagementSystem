package com.AnywareSoftware.StudentManagementSystem.daos;

import com.AnywareSoftware.StudentManagementSystem.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }

    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }
}
