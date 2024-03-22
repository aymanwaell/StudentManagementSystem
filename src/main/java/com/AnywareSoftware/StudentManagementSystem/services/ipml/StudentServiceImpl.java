package com.AnywareSoftware.StudentManagementSystem.services.ipml;

import com.AnywareSoftware.StudentManagementSystem.entities.Student;
import com.AnywareSoftware.StudentManagementSystem.daos.StudentDAO;
import com.AnywareSoftware.StudentManagementSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Student createStudent(Student student) {
        studentDAO.saveStudent(student);
        return student;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentDAO.getStudentById(id);
        if (existingStudent != null) {
            student.setId(existingStudent.getId());
            studentDAO.updateStudent(student);
            return student;
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentDAO.getStudentById(id);
        if (student != null) {
            studentDAO.deleteStudent(student);
        }
    }
}
