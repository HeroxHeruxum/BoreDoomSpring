package com.gruppe4.boredoom.backend.spring.model;

import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.MovieGenre;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Movie extends Media {

    private MovieGenre movieGenre;
    private String director;

    @ElementCollection
    private List<String> mainActors;
    private int duration; // in minutes

    public Movie() {}

    public Movie(MovieGenre movieGenre, String director, List<String> mainActors, int duration) {
        this.movieGenre = movieGenre;
        this.director = director;
        this.mainActors = mainActors;
        this.duration = duration;
    }

    public Movie(long id, String name, String description, String imageUrl, int publishingYear, int minAge, int personCountMin,
            int personCountMax, int durationMin, int durationMax,
            List<ActivityType> activityTypes, Setting setting, MovieGenre movieGenre, String director,
            List<String> mainActors, int duration) {

        super(id, name, description, imageUrl, publishingYear, minAge, personCountMin, personCountMax, durationMin, durationMax,
                activityTypes, setting);
        this.movieGenre = movieGenre;
        this.director = director;
        this.mainActors = mainActors;
        this.duration = duration;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
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
