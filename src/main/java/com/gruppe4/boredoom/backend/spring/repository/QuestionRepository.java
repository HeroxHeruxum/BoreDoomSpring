package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();

    List<String> getChoicesForQuestion(long questionId);

    void mapQuestionTables(Question question);
}
