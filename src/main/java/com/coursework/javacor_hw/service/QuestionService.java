package com.coursework.javacor_hw.service;

import com.coursework.javacor_hw.Question;

import java.util.List;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String question, String answer);
    Question find(String question, String answer);
    List<Question> getAll();
    Question getRandomQuestion();
}
