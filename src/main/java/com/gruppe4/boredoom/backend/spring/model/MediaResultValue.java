package com.gruppe4.boredoom.backend.spring.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MediaResultValue {

    private Media media;
    private double weight;
    private Map<String, Double> singleCriteria;
    private List<String> userPreferences;

    public MediaResultValue(Media media, double weight, Map<String, Double> singleCriteria) {
        this.media = media;
        this.weight = weight;
        this.singleCriteria = singleCriteria;
    }

    public Media getMedia() {
        return media;
    }

    public Map<String, Double> getSingleCriteria() {
        return singleCriteria;
    }

    public List<String> getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(List<String> userPreferences) {
        this.userPreferences = userPreferences;
    }

    public void setSingleCriteria(Map<String, Double> singleCriteria) {
        this.singleCriteria = singleCriteria;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MediaResultValue that = (MediaResultValue) o;
        return media.equals(that.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(media, weight);
    }
}
