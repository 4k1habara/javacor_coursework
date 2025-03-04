package com.coursework.javacor_hw.service;

import com.coursework.javacor_hw.model.Question;
import com.coursework.javacor_hw.exceptions.NotEnoughQuestionsException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    private Set<Question> questions = new HashSet<Question>();

    @Override
    public Set<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size() < amount) {
            throw new NotEnoughQuestionsException();
        }
        while (questions.size() < amount) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }
}