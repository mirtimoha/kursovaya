package com.skypro.javaind.course_work_2.services;

import com.skypro.javaind.course_work_2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
