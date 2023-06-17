package com.skypro.javaind.course_work_2.services.impl;

import com.skypro.javaind.course_work_2.Exceptions.InvalidQuantityQuestionsException;
import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.services.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {

    @Mock
    private QuestionService javaQuestionService;
    @Mock
    private QuestionService mathQuestionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }

    @Test
    void testGetQuestions_AllQuestionsRequested() {
        Question javaQuestion1 = new Question("Java Question 1", "Java Answer 1");
        Question javaQuestion2 = new Question("Java Question 2", "Java Answer 2");
        Set<Question> javaQuestions = new HashSet<>(Set.of(javaQuestion1, javaQuestion2));
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);

        Question mathQuestion1 = new Question("Math Question 1", "Math Answer 1");
        Question mathQuestion2 = new Question("Math Question 2", "Math Answer 2");
        Question mathQuestion3 = new Question("Math Question 3", "Math Answer 3");
        Set<Question> mathQuestions = new HashSet<>(Set.of(mathQuestion1, mathQuestion2, mathQuestion3));
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);

        Collection<Question> allQuestions = examinerService.getQuestions(javaQuestions.size() + mathQuestions.size());

        assertEquals(javaQuestions.size() + mathQuestions.size(), allQuestions.size());
        assertTrue(allQuestions.containsAll(javaQuestions));
        assertTrue(allQuestions.containsAll(mathQuestions));

        verify(javaQuestionService, times(3)).getAll();
        verify(mathQuestionService, times(3)).getAll();
    }

    @Test
    void testGetQuestions_LessThanAllQuestionsRequested() {
        Question javaQuestion1 = new Question("Java Question 1", "Java Answer 1");
        Question javaQuestion2 = new Question("Java Question 2", "Java Answer 2");
        Set<Question> javaQuestions = new HashSet<>(Set.of(javaQuestion1, javaQuestion2));
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);

        Question mathQuestion1 = new Question("Math Question 1", "Math Answer 1");
        Question mathQuestion2 = new Question("Math Question 2", "Math Answer 2");
        Question mathQuestion3 = new Question("Math Question 3", "Math Answer 3");
        Set<Question> mathQuestions = new HashSet<>(Set.of(mathQuestion1, mathQuestion2, mathQuestion3));
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);

        List<Question> javaList = new ArrayList<>(javaQuestions);
        List<Question> mathList = new ArrayList<>(mathQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(javaList.get(0));
        when(mathQuestionService.getRandomQuestion()).thenReturn(mathList.get(0),mathList.get(2));

        Collection<Question> selectedQuestions = examinerService.getQuestions(3);
        assertIterableEquals(new HashSet<>(List.of(javaList.get(0),mathList.get(0),mathList.get(2))),selectedQuestions);

        assertEquals(3, selectedQuestions.size());

    }

    @Test
    void testGetQuestions_NoQuestionsRequested() {
        assertThrows(InvalidQuantityQuestionsException.class, () -> {
            examinerService.getQuestions(0);
        });
        verify(javaQuestionService, times(1)).getAll();
        verify(mathQuestionService, times(1)).getAll();
    }
}
