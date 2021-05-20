package com.gruppe4.boredoom.backend.spring.model;

import com.gruppe4.boredoom.backend.spring.model.enums.QuestionType;

import java.util.List;

public class Question {

    private long id;
    private String text;
    private QuestionType type;
    private List<Choice> choices;

    public Question() {}

    public Question(long id, String text, QuestionType type, List<Choice> choices) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }


}
