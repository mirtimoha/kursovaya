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
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionServiceImpl")QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String questionText,
                                @RequestParam String questionAnswer) {
        return questionService.add(questionText, questionAnswer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String questionText,
                                   @RequestParam String questionAnswer) {
        return questionService.remove(new Question(questionText,questionAnswer));
    }

    @GetMapping()
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }
}
