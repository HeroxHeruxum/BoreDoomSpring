package com.gruppe4.boredoom.backend.spring.model;

import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;

import java.util.List;

public class Movie extends Media {

    private String director;
    private List<String> mainActors;
    private int duration; // in minutes

    public Movie() {}

    public Movie(String director, List<String> mainActors, int duration) {
        this.director = director;
        this.mainActors = mainActors;
        this.duration = duration;
    }

    public Movie(long id, String name, String description, String imageUrl, int publishingYear, int minAge, int personCountMin,
            int personCountMax, int durationMin, int durationMax,
            List<ActivityType> activityTypes, Setting setting, String director,
            List<String> mainActors, int duration) {

        super(id, MediaType.MOVIE, name, description, imageUrl, publishingYear, minAge, personCountMin, personCountMax,
                durationMin, durationMax,
                activityTypes, setting);
        this.director = director;
        this.mainActors = mainActors;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getMainActors() {
        return mainActors;
    }

    public void setMainActors(List<String> mainActors) {
        this.mainActors = mainActors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
