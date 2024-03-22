package com.AnywareSoftware.StudentManagementSystem.services.ipml;

import com.AnywareSoftware.StudentManagementSystem.entities.Quiz;
import com.AnywareSoftware.StudentManagementSystem.daos.QuizDAO;
import com.AnywareSoftware.StudentManagementSystem.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizDAO quizDAO;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        quizDAO.saveQuiz(quiz);
        return quiz; // Optional: return the saved quiz
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizDAO.getQuizById(id);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizDAO.getAllQuizzes();
    }

    @Override
    public Quiz updateQuiz(Long id, Quiz quiz) {
        Quiz existingQuiz = quizDAO.getQuizById(id);
        if (existingQuiz != null) {
            quiz.setId(existingQuiz.getId());
            quizDAO.updateQuiz(quiz);
            return quiz; // Optional: return the updated quiz
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteQuiz(Long id) {
        Quiz quiz = quizDAO.getQuizById(id);
        if (quiz != null) {
            quizDAO.deleteQuiz(quiz);
        }
    }
}
