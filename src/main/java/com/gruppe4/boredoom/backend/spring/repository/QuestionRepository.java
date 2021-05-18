package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Question;
import com.gruppe4.boredoom.backend.spring.model.enums.QuestionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Repository
public class QuestionRepository extends Repository{

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionRepository.class);

    public QuestionRepository(@Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password){
        super(url, username, password);
    }

    public List<Question> getAll(){

        String sqlSelectAllQuestions = "SELECT q.*, qt.question_type FROM question q JOIN question_type qt ON q.question_type_id " +
                "= qt.id";

       List<Question> questionList = executeSql(sqlSelectAllQuestions, this::transformQuestion);

        for (Question question : questionList) {
            String sqlSelectChoices = "SELECT choice FROM choice c JOIN question2choice q2c ON c.id = q2c.choice_id " +
                    "WHERE q2c.question_id = " + question.getId();
            List<String> choices = executeSql(sqlSelectChoices, this::transformChoice);
            question.setChoices(choices);
        }
          return questionList;
    }

    private Question transformQuestion(ResultSet rs) {
        var question = new Question();
        try {
            question.setId(rs.getLong("id"));
            question.setText(rs.getString("question"));
            question.setType(QuestionType.fromString(rs.getString("question_type")));
            return question;
        } catch (SQLException throwables) {
            LOGGER.error("Questions object could not be created", throwables);
        }
        return null;
    }

    private String transformChoice(ResultSet rs) {
        try {
            return rs.getString("choice");
        } catch (SQLException throwables) {
            LOGGER.error("String object with choice could not be created", throwables);
        }
        return null;
    }
}
