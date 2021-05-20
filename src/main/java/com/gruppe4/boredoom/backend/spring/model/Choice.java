package com.gruppe4.boredoom.backend.spring.model;

public class Choice {

    private long id;
    private String value;
    private EvaluationValue evaluationValue; // "Gruselig"
    private long evaluationValueId;
    private double weight;

    public Choice(){};

    public Choice(long id, String value, EvaluationValue evaluationValue,long evaluationValueId, double weight) {
        this.id = id;
        this.value = value;
        this.evaluationValue = evaluationValue;
        this.evaluationValueId = evaluationValueId;
        this.weight = weight;
    }

    public long getEvaluationValueId() {
        return evaluationValueId;
    }

    public void setEvaluationValueId(long evaluationValueId) {
        this.evaluationValueId = evaluationValueId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EvaluationValue getEvaluationValue() {
        return evaluationValue;
    }

    public void setEvaluationValue(EvaluationValue evaluationValue) {
        this.evaluationValue = evaluationValue;
    }
}
