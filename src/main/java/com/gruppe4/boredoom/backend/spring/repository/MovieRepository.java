package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.MovieGenre;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAll();

    List<String> getActorsForMovie(long id);

    List<ActivityType> getActivityTypesForMovie(long id);

    List<MovieGenre> getGenresForMovie(long id);

    List<Movie> findMoviesForUser(String username);

}
