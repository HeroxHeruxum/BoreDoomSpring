package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Question;
import com.gruppe4.boredoom.backend.spring.model.enums.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Repository
public class QuestionRepository extends Repository{

    public QuestionRepository(@Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password){
        super(url, username, password);
    }

    public List<Question> getAll(){

        String sqlSelectAllQuestions = "SELECT q.*, qt.question_type FROM question q JOIN question_type qt ON q.question_type_id " +
                "= qt.id";
        var questions =executeSql(sqlSelectAllQuestions, this::transformQuestion);
        return questions;
    }

    private Question transformQuestion(ResultSet rs) {
        var question = new Question();
        try {
            question.setId(rs.getLong("id"));
            question.setText(rs.getString("question"));
            question.setType(QuestionType.fromString(rs.getString("question_type")));
            return question;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
