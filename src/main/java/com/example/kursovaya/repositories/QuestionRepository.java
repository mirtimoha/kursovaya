package com.skypro.javaind.course_work_2.repositories;

import com.skypro.javaind.course_work_2.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    void add (Question question);
    void remove (Question question);
    Collection<Question> getAll();
}
