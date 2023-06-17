package com.skypro.javaind.course_work_2.repositories.impl;

import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.repositories.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MathQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> mathQuestions;

    public MathQuestionRepositoryImpl() {
        this.mathQuestions = new HashSet<>();
    }
    @PostConstruct
    void init(){
        mathQuestions.addAll(new ArrayList<>(List.of(
                new Question("mathQuestion1", "mathAnswer1"),
                new Question("mathQuestion2", "mathAnswer2"),
                new Question("mathQuestion3", "mathAnswer3"),
                new Question("mathQuestion4", "mathAnswer4"))));
    }
    @Override
    public void add(Question question) {
        mathQuestions.add(question);
    }

    @Override
    public void remove(Question question) {
        mathQuestions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(mathQuestions);
    }
}
