package com.skypro.javaind.course_work_2.repositories.impl;

import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.repositories.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> javaQuestions;

    public JavaQuestionRepositoryImpl() {
        this.javaQuestions = new HashSet<>();
    }
    @PostConstruct
    void init(){
        javaQuestions.addAll(new ArrayList<>(List.of(
                new Question("javaQuestion1", "javaAnswer1"),
                new Question("javaQuestion2", "javaAnswer2"),
                new Question("javaQuestion3", "javaAnswer3"),
                new Question("javaQuestion4", "javaAnswer4"),
                new Question("javaQuestion5", "javaAnswer5"))));
    }
    @Override
    public void add(Question question) {
        javaQuestions.add(question);
    }

    @Override
    public void remove(Question question) {
        javaQuestions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(javaQuestions);
    }
}
