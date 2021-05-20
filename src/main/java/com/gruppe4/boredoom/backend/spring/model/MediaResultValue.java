package com.gruppe4.boredoom.backend.spring.model;

import java.util.Map;
import java.util.Objects;

public class MediaResultValue {

    private Media media;
    private double weight;

    public MediaResultValue(Media media, double weight, Map<String, Double> singleCriteria) {
        this.media = media;
        this.weight = weight;
        this.singleCriteria = singleCriteria;
    }

    private Map<String, Double> singleCriteria;

    public Media getMedia() {
        return media;
    }

    public Map<String, Double> getSingleCriteria() {
        return singleCriteria;
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
