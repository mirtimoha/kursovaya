package com.skypro.javaind.course_work_2.services.impl;
import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class JavaQuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;
    private JavaQuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        questionService = new JavaQuestionServiceImpl(questionRepository);
    }

    @Test
    void testAddQuestion() {
        Question question = new Question("Question 1", "Answer 1");

        questionService.add(question);

        verify(questionRepository, times(1)).add(question);
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("Question 1", "Answer 1");

        questionService.remove(question);

        verify(questionRepository, times(1)).remove(question);
    }

    @Test
    void testGetAllQuestions() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");
        Collection<Question> expectedQuestions = new HashSet<>(Arrays.asList(question1, question2));
        when(questionRepository.getAll()).thenReturn(expectedQuestions);

        Collection<Question> allQuestions = questionService.getAll();

        assertIterableEquals(expectedQuestions, allQuestions);
        verify(questionRepository, times(1)).getAll();
    }

    @Test
    void testGetRandomQuestion() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");
        Collection<Question> questions = new HashSet<>(Arrays.asList(question1, question2));
        when(questionRepository.getAll()).thenReturn(questions);

        Question randomQuestion = questionService.getRandomQuestion();

        assertTrue(questions.contains(randomQuestion));
        verify(questionRepository, times(2)).getAll();
    }
}
