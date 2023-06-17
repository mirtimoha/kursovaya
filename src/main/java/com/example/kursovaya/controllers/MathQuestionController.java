package com.skypro.javaind.course_work_2.controllers;

import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionServiceImpl") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("QuestionText") String questionText,
                                @RequestParam("QuestionAnswer") String questionAnswer) {
        return questionService.add(questionText, questionAnswer);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("QuestionText") String questionText,
                                   @RequestParam("QuestionAnswer") String questionAnswer) {
        return questionService.remove(new Question(questionText, questionAnswer));
    }
}
