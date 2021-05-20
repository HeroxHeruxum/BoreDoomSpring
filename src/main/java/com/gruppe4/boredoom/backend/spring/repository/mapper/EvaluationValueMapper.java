package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.EvaluationValue;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EvaluationValueMapper implements RowMapper<EvaluationValue> {

    @Override
    public EvaluationValue mapRow(ResultSet resultSet, int i) throws SQLException {
        var evaluationValue = new EvaluationValue();
        evaluationValue.setValue(resultSet.getString("evaluation_value"));
        evaluationValue.setEvaluationTypeId(resultSet.getLong("evaluation_type_id"));
        return evaluationValue;
    }
}
