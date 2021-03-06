package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Genre;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAll();

    List<String> getActorsForMovie(long id);

    List<ActivityType> getActivityTypesForMovie(long id);

    List<Genre> getGenresForMovie(long id);

    List<Movie> findMoviesForUser(String username);

}
