package com.AnywareSoftware.StudentManagementSystem.services;

import com.AnywareSoftware.StudentManagementSystem.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);
    Quiz getQuizById(Long id);
    List<Quiz> getAllQuizzes();
    Quiz updateQuiz(Long id, Quiz quiz);
    void deleteQuiz(Long id);
}
