package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Question;
import com.gruppe4.boredoom.backend.spring.repository.mapper.QuestionMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final JdbcTemplate jdbcTemplate;
    private final QuestionMapper questionMapper;

    public QuestionRepositoryImpl(JdbcTemplate jdbcTemplate,
            QuestionMapper questionMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionMapper = questionMapper;
    }

    @Override
    public List<Question> getAll(){
        List<Question> questions = jdbcTemplate.query("SELECT q.*, qt.question_type FROM question q JOIN question_type qt ON q.question_type_id " +
                "= qt.id", questionMapper);

        questions.forEach(this::mapQuestionTables);
        return questions;
    }

    @Override
    public List<String> getChoicesForQuestion(long questionId){
        return jdbcTemplate.queryForList("SELECT choice FROM choice c JOIN question2choice q2c ON c.id = q2c" +
                ".choice_id WHERE q2c.question_id = ? ", String.class, questionId);
    }

    @Override
    public void mapQuestionTables(Question question) {
        long questionId = question.getId();
        question.setChoices(getChoicesForQuestion(questionId));
    }
}
