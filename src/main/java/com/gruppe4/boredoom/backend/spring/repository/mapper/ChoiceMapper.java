package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.Choice;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ChoiceMapper implements RowMapper<Choice> {

    @Override
    public Choice mapRow(ResultSet resultSet, int i) throws SQLException {
        var choice = new Choice();
        choice.setId(resultSet.getLong("id"));
        choice.setValue(resultSet.getString("choice"));
        choice.setEvaluationValueId(resultSet.getLong("evaluation_value_id"));
        choice.setWeight(resultSet.getDouble("weight"));
        return choice;
    }
}
