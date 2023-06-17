package com.skypro.javaind.course_work_2.services;

import com.skypro.javaind.course_work_2.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add (String question, String answer);
    Question add (Question question);
    Question remove (Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
