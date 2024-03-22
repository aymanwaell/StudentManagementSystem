package com.AnywareSoftware.StudentManagementSystem.services;

import com.AnywareSoftware.StudentManagementSystem.entities.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    List<Teacher> getAllTeachers();
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
}
