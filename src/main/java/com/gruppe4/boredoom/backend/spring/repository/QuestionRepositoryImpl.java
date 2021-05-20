package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Choice;
import com.gruppe4.boredoom.backend.spring.model.EvaluationType;
import com.gruppe4.boredoom.backend.spring.model.EvaluationValue;
import com.gruppe4.boredoom.backend.spring.model.Question;
import com.gruppe4.boredoom.backend.spring.repository.mapper.ChoiceMapper;
import com.gruppe4.boredoom.backend.spring.repository.mapper.EvaluationTypeMapper;
import com.gruppe4.boredoom.backend.spring.repository.mapper.EvaluationValueMapper;
import com.gruppe4.boredoom.backend.spring.repository.mapper.QuestionMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final JdbcTemplate jdbcTemplate;
    private final QuestionMapper questionMapper;
    private final ChoiceMapper choiceMapper;
    private final EvaluationValueMapper evaluationValueMapper;
    private final EvaluationTypeMapper evaluationTypeMapper;

    public QuestionRepositoryImpl(JdbcTemplate jdbcTemplate,
            QuestionMapper questionMapper, ChoiceMapper choiceMapper, EvaluationValueMapper evaluationValueMapper,
            EvaluationTypeMapper evaluationTypeMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionMapper = questionMapper;
        this.choiceMapper = choiceMapper;
        this.evaluationValueMapper = evaluationValueMapper;
        this.evaluationTypeMapper = evaluationTypeMapper;
    }

    @Override
    public List<Question> getAll(){
        List<Question> questions = jdbcTemplate.query("SELECT q.*, qt.question_type FROM question q JOIN question_type qt ON q.question_type_id " +
                "= qt.id", questionMapper);

        questions.forEach(this::mapQuestionTables);
        return questions;
    }

    @Override
    public List<Choice> getChoicesForQuestion(long questionId){
        List<Choice> choices =  jdbcTemplate.query("SELECT * FROM choice c JOIN question2choice q2c ON c.id = q2c" +
                ".choice_id WHERE q2c.question_id = ? " , choiceMapper , questionId);

        choices.forEach(this::mapChoiceTables);
        return choices;
    }

    @Override
    public EvaluationValue getEvaluationValueForChoice(long evaluationValueId){
        var evaluationValue = jdbcTemplate.queryForObject("SELECT * FROM evaluation_value ev " +
                        "WHERE ev.id = ?", evaluationValueMapper, evaluationValueId);

        assert evaluationValue != null;
        mapEvaluationValueTabel(evaluationValue);
        return evaluationValue;
    }

    @Override
    public EvaluationType getEvaluationTypeForEvaluationValue(long evaluationTypeId){
        return jdbcTemplate.queryForObject("SELECT * FROM evaluation_type et " +
                "WHERE et.id = ?", evaluationTypeMapper, evaluationTypeId);
    }

    @Override
    public void mapQuestionTables(Question question) {
        long questionId = question.getId();
        question.setChoices(getChoicesForQuestion(questionId));
    }

    @Override
    public void mapChoiceTables(Choice choice){
        long evaluationValueId = choice.getEvaluationValueId();
        choice.setEvaluationValue(getEvaluationValueForChoice(evaluationValueId));
    }

    @Override
    public void mapEvaluationValueTabel(EvaluationValue evaluationValue){
        long evaluationTypeId = evaluationValue.getEvaluationTypeId();
        evaluationValue.setEvaluationType(getEvaluationTypeForEvaluationValue(evaluationTypeId));
    }
}
