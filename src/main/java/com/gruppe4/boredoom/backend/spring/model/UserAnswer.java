package com.gruppe4.boredoom.backend.spring.model;

import java.util.List;

public class UserAnswer {

    private long questionId;
    private List<Long> choices;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public List<Long> getChoices() {
        return choices;
    }

    public void setChoices(List<Long> choices) {
        this.choices = choices;
    }
}
