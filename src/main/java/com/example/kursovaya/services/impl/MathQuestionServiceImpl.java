package com.skypro.javaind.course_work_2.services.impl;

import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.repositories.QuestionRepository;
import com.skypro.javaind.course_work_2.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionServiceImpl implements QuestionService {

    private final QuestionRepository mathQuestions;

    private final Random random = new Random();

    public MathQuestionServiceImpl(@Qualifier("mathQuestionRepositoryImpl") QuestionRepository javaQuestions) {
        this.mathQuestions = javaQuestions;
    }


    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question,answer);
        mathQuestions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions.getAll();
    }

    @Override
    public Question getRandomQuestion() {

//        return questions.stream().skip(new Random().nextInt(questions.size())).findFirst().orElse(null);

        int item = random.nextInt(mathQuestions.getAll().size());
        int i = 0;
        for (Question question : mathQuestions.getAll()) {
            if(i == item){
                return question;
            }
            i++;
        }
        return null;
    }
}
