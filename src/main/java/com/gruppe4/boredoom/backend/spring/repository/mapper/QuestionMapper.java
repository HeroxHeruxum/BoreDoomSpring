package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.Question;
import com.gruppe4.boredoom.backend.spring.model.enums.QuestionType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuestionMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {
        var question = new Question();
        question.setId(resultSet.getLong("id"));
        question.setText(resultSet.getString("question"));
        question.setType(QuestionType.fromString(resultSet.getString("question_type")));
        return question;
    }
}
