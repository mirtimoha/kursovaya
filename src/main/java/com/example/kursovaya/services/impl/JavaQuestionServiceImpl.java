package com.skypro.javaind.course_work_2.services.impl;

import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.repositories.QuestionRepository;
import com.skypro.javaind.course_work_2.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final QuestionRepository javaQuestions;
    private final Random random = new Random();

    public JavaQuestionServiceImpl(@Qualifier("javaQuestionRepositoryImpl") QuestionRepository javaQuestions) {
        this.javaQuestions = javaQuestions;
    }


    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question,answer);
        javaQuestions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestions.getAll();
    }

    @Override
    public Question getRandomQuestion() {

//        return questions.stream().skip(new Random().nextInt(questions.size())).findFirst().orElse(null);

        int item = random.nextInt(javaQuestions.getAll().size());
        int i = 0;
        for (Question question : javaQuestions.getAll()) {
            if(i == item){
                return question;
            }
            i++;
        }
        return null;
    }
}
