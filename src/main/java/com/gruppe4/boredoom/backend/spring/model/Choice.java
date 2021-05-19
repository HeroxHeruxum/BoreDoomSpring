package com.gruppe4.boredoom.backend.spring.model;

public class Choice {

    private long id;
    private String value;
    private String evaluationType; // "ActivityType"
    private String evaluationValue; // "Gruselig"
    private double weight;

    public Choice(long id, String value, String evaluationType, String evaluationValue, double weight) {
        this.id = id;
        this.value = value;
        this.evaluationType = evaluationType;
        this.evaluationValue = evaluationValue;
        this.weight = weight;
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

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public Object getEvaluationValue() {
        return evaluationValue;
    }

    public void setEvaluationValue(String evaluationValue) {
        this.evaluationValue = evaluationValue;
    }
}
