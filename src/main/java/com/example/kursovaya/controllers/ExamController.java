package com.skypro.javaind.course_work_2.controllers;

import com.skypro.javaind.course_work_2.model.Question;
import com.skypro.javaind.course_work_2.services.ExaminerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("exam/{amount}")
    public Collection<Question> getQuestion (@PathVariable("amount") int amount){
        return examinerService.getQuestions(amount);
    }
}
