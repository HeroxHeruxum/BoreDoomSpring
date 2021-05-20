package com.gruppe4.boredoom.backend.spring.model;

import java.util.List;

public class EvaluationType {

    private long id;
    private String type;

    public EvaluationType(){};

    public EvaluationType(long id, String type,
            List<EvaluationValue> evaluationValueList) {
        this.id = id;
        this.type = type;
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
}
