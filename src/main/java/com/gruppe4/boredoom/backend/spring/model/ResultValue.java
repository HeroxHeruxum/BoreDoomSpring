package com.gruppe4.boredoom.backend.spring.model;

import java.util.List;

public class ResultValue {

    private String name;
    private double weight;
    private List<Media> results;

    public ResultValue() {
    }

    public ResultValue(String name, double weight, List<Media> results) {
        this.name = name;
        this.weight = weight;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Media> getResults() {
        return results;
    }

    public void setResults(List<Media> results) {
        this.results = results;
    }
}
