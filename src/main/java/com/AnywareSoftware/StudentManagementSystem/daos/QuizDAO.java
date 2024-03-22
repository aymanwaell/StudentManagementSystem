package com.AnywareSoftware.StudentManagementSystem.daos;

import com.AnywareSoftware.StudentManagementSystem.entities.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class QuizDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveQuiz(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.save(quiz);
    }

    public void updateQuiz(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.update(quiz);
    }

    public void deleteQuiz(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(quiz);
    }

    public Quiz getQuizById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Quiz.class, id);
    }

    public List<Quiz> getAllQuizzes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Quiz", Quiz.class).list();
    }
}
