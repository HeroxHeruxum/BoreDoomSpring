package com.gruppe4.boredoom.backend.spring.model;

import java.util.List;

public class Answer {

    private long questionId;
    private List<String> selectedChoices;

    public Answer() {}

    public Answer(long questionId, List<String> selectedChoices) {
        this.questionId = questionId;
        this.selectedChoices = selectedChoices;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public List<String> getSelectedChoices() {
        return selectedChoices;
    }

    public void setSelectedChoices(List<String> selectedChoices) {
        this.selectedChoices = selectedChoices;
    }
}
