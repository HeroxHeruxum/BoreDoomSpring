package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Choice;
import com.gruppe4.boredoom.backend.spring.model.EvaluationType;
import com.gruppe4.boredoom.backend.spring.model.EvaluationValue;
import com.gruppe4.boredoom.backend.spring.model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();

    List<Choice> getChoicesForQuestion(long questionId);

    EvaluationValue getEvaluationValueForChoice(long choiceId);

    EvaluationType getEvaluationTypeForEvaluationValue(long evaluationTypeId);

    void mapQuestionTables(Question question);

    void mapChoiceTables(Choice choice);

    void mapEvaluationValueTabel(EvaluationValue evaluationValue);
}
