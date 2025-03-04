package com.coursework.javacor_hw.service;

import com.coursework.javacor_hw.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {

    @Mock
    JavaQuestionService questionServiceMock;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    private Question question = new Question("a", "a");
    private List<Question> actualList = new ArrayList<Question>();
    private Set<Question> expectedList = new HashSet<Question>();

    @BeforeEach
    public void setUp() {
        actualList.add(question);
        expectedList.add(question);
    }

    @Test
    void getQuestions() {

        when(questionServiceMock.getAll()).thenReturn(actualList);
        when(questionServiceMock.getRandomQuestion()).thenReturn(question);

        Set<Question> expected = expectedList;
        Set<Question> actual = examinerService.getQuestions(1);

        assertEquals(expected, actual);
    }
}