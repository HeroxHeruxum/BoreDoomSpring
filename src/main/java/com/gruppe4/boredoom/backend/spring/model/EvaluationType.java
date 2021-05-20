package com.gruppe4.boredoom.backend.spring.model;

import java.util.List;

public class EvaluationType {

    private long id;
    private String type;
    private List<EvaluationValue> evaluationValueList;

    public EvaluationType(){};

    public EvaluationType(long id, String type,
            List<EvaluationValue> evaluationValueList) {
        this.id = id;
        this.type = type;
        this.evaluationValueList = evaluationValueList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EvaluationValue> getEvaluationValueList() {
        return evaluationValueList;
    }

    public void setEvaluationValueList(List<EvaluationValue> evaluationValueList) {
        this.evaluationValueList = evaluationValueList;
    }
}
