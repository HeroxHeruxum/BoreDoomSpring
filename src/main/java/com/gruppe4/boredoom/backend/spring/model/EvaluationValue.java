package com.gruppe4.boredoom.backend.spring.model;

public class EvaluationValue {

    private long id;
    private String value;
    private EvaluationType evaluationType;
    private long evaluationTypeId;

    public EvaluationValue(){};

    public EvaluationValue(long id, String value, EvaluationType evaluationType, long evaluationTypeId) {
        this.id = id;
        this.value = value;
        this.evaluationType = evaluationType;
        this.evaluationTypeId = evaluationTypeId;
    }

    public long getEvaluationTypeId() {
        return evaluationTypeId;
    }

    public void setEvaluationTypeId(long evaluationTypeId) {
        this.evaluationTypeId = evaluationTypeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EvaluationType getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(EvaluationType evaluationType) {
        this.evaluationType = evaluationType;
    }
}
