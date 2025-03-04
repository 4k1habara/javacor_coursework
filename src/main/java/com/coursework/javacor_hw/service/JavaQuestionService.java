package com.coursework.javacor_hw.service;

import com.coursework.javacor_hw.Question;
import com.coursework.javacor_hw.exceptions.QuestionAlreadyAddedException;
import com.coursework.javacor_hw.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    Map<Integer, Question> questionMap = new HashMap<Integer, Question>();

    @Override
    public Question add(String question, String answer) {

        int questionNumber = questionMap.size();
        Question questionCopy = new Question(question, answer);

        if (!(questionMap.containsValue(questionCopy))) {
            questionMap.put(questionNumber, questionCopy);
            return questionCopy;
        }
        throw new QuestionAlreadyAddedException();
    }

    @Override
    public Question remove(String question, String answer) {

        Integer questionNumber = 0;
        Question questionCopy = new Question(question, answer);
        Set<Map.Entry<Integer, Question>> entrySet = questionMap.entrySet();

        if (!(questionMap.containsValue(questionCopy))) {
            throw new QuestionNotFoundException();
        }

        for (Map.Entry<Integer, Question> pair : entrySet) {
            if (questionCopy.equals(pair.getValue())) {
                questionNumber = pair.getKey();
                questionMap.remove(questionNumber, questionCopy);
            }
        }
        return questionCopy;
    }

    @Override
    public Question find(String question, String answer) {

        Question questionCopy = new Question(question, answer);

        if (questionMap.containsValue(questionCopy)) {
            return questionCopy;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public List<Question> getAll() {
        return new ArrayList<Question>(questionMap.values());
    }

    @Override
    public Question getRandomQuestion() {

        Random rn = new Random();
        int max = questionMap.size();
        int randomNum = rn.nextInt(max);
        Question question = null;

        for (Map.Entry<Integer, Question> entry : questionMap.entrySet()) {
            if (entry.getKey() == randomNum) {
                question = entry.getValue();
            }
        }

        return question;
    }
}
