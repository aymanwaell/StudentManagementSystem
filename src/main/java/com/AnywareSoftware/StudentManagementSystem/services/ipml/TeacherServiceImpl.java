package com.AnywareSoftware.StudentManagementSystem.services.ipml;

import com.AnywareSoftware.StudentManagementSystem.entities.Teacher;
import com.AnywareSoftware.StudentManagementSystem.daos.TeacherDAO;
import com.AnywareSoftware.StudentManagementSystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
        return teacher; // Optional: return the saved teacher
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDAO.getTeacherById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existingTeacher = teacherDAO.getTeacherById(id);
        if (existingTeacher != null) {
            teacher.setId(existingTeacher.getId());
            teacherDAO.updateTeacher(teacher);
            return teacher; // Optional: return the updated teacher
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = teacherDAO.getTeacherById(id);
        if (teacher != null) {
            teacherDAO.deleteTeacher(teacher);
        }
    }
}
