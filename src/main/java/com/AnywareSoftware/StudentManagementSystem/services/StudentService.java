package com.AnywareSoftware.StudentManagementSystem.services;

import com.AnywareSoftware.StudentManagementSystem.entities.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
