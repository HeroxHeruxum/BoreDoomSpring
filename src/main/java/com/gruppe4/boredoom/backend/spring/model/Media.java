package com.gruppe4.boredoom.backend.spring.model;

import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;

import java.util.List;

public abstract class Media {

    private long id;
    private MediaType mediaType;
    private String name;
    private String description;
    private String imageUrl;
    private int publishingYear;
    private int minAge;

    // Generelle Auswertungsattribute
    private int personCountMin;
    private int personCountMax;
    private int durationMin; // in Stunden
    private int durationMax; // in Stunden

    private List<ActivityType> activityTypes;
    private Setting setting;

    protected Media() {}

    public Media(long id, MediaType mediaType, String name, String description, String imageUrl, int publishingYear, int minAge,
            int personCountMin, int personCountMax, int durationMin, int durationMax,
            List<ActivityType> activityTypes, Setting setting) {
        this.id = id;
        this.mediaType = mediaType;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.publishingYear = publishingYear;
        this.minAge = minAge;
        this.personCountMin = personCountMin;
        this.personCountMax = personCountMax;
        this.durationMin = durationMin;
        this.durationMax = durationMax;
        this.activityTypes = activityTypes;
        this.setting = setting;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPersonCountMin() {
        return personCountMin;
    }

    public void setPersonCountMin(int personCountMin) {
        this.personCountMin = personCountMin;
    }

    public int getPersonCountMax() {
        return personCountMax;
    }

    public void setPersonCountMax(int personCountMax) {
        this.personCountMax = personCountMax;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public int getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(int durationMax) {
        this.durationMax = durationMax;
    }

    public List<ActivityType> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<ActivityType> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}