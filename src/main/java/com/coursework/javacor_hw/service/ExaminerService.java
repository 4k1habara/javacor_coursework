package com.coursework.javacor_hw.service;

import com.coursework.javacor_hw.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
