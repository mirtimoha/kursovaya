package com.skypro.javaind.course_work_2.repositories.impl;

import com.skypro.javaind.course_work_2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryImplTest {
    private MathQuestionRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new MathQuestionRepositoryImpl();
    }

    @Test
    void testAddQuestionToRepository() {
        Question question = new Question("Question", "Answer");
        repository.add(question);

        assertTrue(repository.getAll().contains(question));
    }

    @Test
    void testRemoveQuestionFromRepository() {
        Question question = new Question("Question", "Answer");
        repository.add(question);

        repository.remove(question);

        assertFalse(repository.getAll().contains(question));
    }

    @Test
    void testReturnAllQuestionsInRepository() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");
        repository.add(question1);
        repository.add(question2);

        Collection<Question> questions = repository.getAll();

        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
    }
}