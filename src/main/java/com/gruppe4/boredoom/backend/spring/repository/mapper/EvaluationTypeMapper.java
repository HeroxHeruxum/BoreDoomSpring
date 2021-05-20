package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.EvaluationType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EvaluationTypeMapper implements RowMapper<EvaluationType> {

    @Override
    public EvaluationType mapRow(ResultSet resultSet, int i) throws SQLException {
        var evaluationType = new EvaluationType();
        evaluationType.setType(resultSet.getString("evaluation_type"));
        return null;
    }
}
