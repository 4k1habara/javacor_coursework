package com.coursework.javacor_hw.service;

import com.coursework.javacor_hw.model.Question;
import com.coursework.javacor_hw.exceptions.QuestionAlreadyAddedException;
import com.coursework.javacor_hw.exceptions.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    private Question question = new Question("a", "a");


    @Test
    void whenAdd() {

        Question expected = question;
        Question actual = javaQuestionService.add("a", "a");

        assertEquals(expected, actual);
    }

    @Test
    void whenAddSameQuestion() {

        Question actual = javaQuestionService.add("a", "a");

        assertThrows(QuestionAlreadyAddedException.class, () -> javaQuestionService.add("a", "a"));
    }

    @Test
    void remove() {

        javaQuestionService.add("a", "a");

        Question expected = new Question("a", "a");
        Question actual = javaQuestionService.remove("a", "a");

        assertEquals(expected, actual);
    }

    @Test
    void questionNotFound() {

        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove("a", "a"));
    }

    @Test
    void find() {

        javaQuestionService.add("a", "a");

        Question expected = new Question("a", "a");
        Question actual = javaQuestionService.find("a", "a");

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {

        Question question = new Question("a", "a");
        javaQuestionService.add("a", "a");

        List<Question> expected = new ArrayList<Question>();
        expected.add(question);
        List<Question> actual = javaQuestionService.getAll();

        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {

        javaQuestionService.add("a", "a");

        Question expected = question;
        Question actual = javaQuestionService.getRandomQuestion();

        assertEquals(expected, actual);
    }
}