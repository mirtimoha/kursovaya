package com.skypro.javaind.course_work_2.services.impl;

import com.skypro.javaind.course_work_2.Exceptions.InvalidQuantityQuestionsException;
import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.services.ExaminerService;
import com.skypro.javaind.course_work_2.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > (javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) || amount == 0) {
            throw new InvalidQuantityQuestionsException("Запрошено 0 вопросов, либо количество запрошенных вопросов превышает общее количество вопросов в коллекциях");
        }
        if (amount == (javaQuestionService.getAll().size() + mathQuestionService.getAll().size())) {
            Set<Question> result = new HashSet<>();
            result.addAll(javaQuestionService.getAll());
            result.addAll(mathQuestionService.getAll());
            return result;
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount){
            if (random.nextDouble() < 0.5){
                if (!javaQuestionService.getAll().isEmpty()) {
                    questions.add(javaQuestionService.getRandomQuestion());
                }
            } else {
                if (!mathQuestionService.getAll().isEmpty()) {
                    questions.add(mathQuestionService.getRandomQuestion());
                }
            }
        }
        return questions;
    }
}
