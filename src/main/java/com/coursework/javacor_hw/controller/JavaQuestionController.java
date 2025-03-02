package com.coursework.javacor_hw.controller;

import com.coursework.javacor_hw.model.Question;
import com.coursework.javacor_hw.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.remove(question, answer);
    }

    @GetMapping("find")
    public Question findQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.find(question, answer);
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }
}
