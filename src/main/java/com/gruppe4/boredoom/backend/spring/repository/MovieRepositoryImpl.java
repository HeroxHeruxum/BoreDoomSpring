package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Genre;
import com.gruppe4.boredoom.backend.spring.repository.mapper.MovieMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MovieMapper movieMapper;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate,
            MovieMapper movieMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = jdbcTemplate.query("SELECT m.*, d.full_name, s.setting from movie m" +
                "  JOIN director d on (m.director_id = d.id)" +
                "  JOIN setting s on (m.setting_id = s.id)", movieMapper);

        movies.forEach(m -> mapMovieTables(m));
        return movies;
    }

    @Override
    public List<String> getActorsForMovie(long id) {
        return jdbcTemplate.queryForList("SELECT a.full_name from actor a " +
                "  JOIN movie2actor m2a on (m2a.actor_id = a.id)" +
                "  JOIN movie m on (m.id = m2a.movie_id)" +
                "  WHERE m.id = ?;", String.class, id);
    }

    @Override
    public List<ActivityType> getActivityTypesForMovie(long id) {
        List<String> activityTypesStr = jdbcTemplate.queryForList("SELECT a.activity_type from activity_type a" +
                "  JOIN movie2activity_type m2a on (m2a.activity_type_id = a.id)" +
                "  JOIN movie m on (m.id = m2a.movie_id)" +
                "  WHERE m.id = ?;", String.class, id);

        List<ActivityType> activityTypes = new ArrayList<>();

        activityTypesStr.forEach(s -> activityTypes.add(ActivityType.fromString(s)));

        return activityTypes;
    }

    @Override
    public List<Genre> getGenresForMovie(long id) {

        List<String> genresStr = jdbcTemplate.queryForList("SELECT mg.genre from genre mg" +
                "  JOIN movie2movie_genre m2m on (mg.id = m2m.movie_genre_id)" +
                "  JOIN movie m on (m2m.movie_id = m.id)" +
                "  WHERE m.id = ?;", String.class, id);

        List<Genre> movieGenres = new ArrayList<>();

        genresStr.forEach(s -> movieGenres.add(Genre.fromString(s)));

        return movieGenres;
    }

    @Override
    public List<Movie> findMoviesForUser(String username) {
        List<Movie> movies = jdbcTemplate.query("SELECT m.*, d.full_name, s.setting from movie m" +
                "  JOIN director d on (m.director_id = d.id)" +
                "  JOIN setting s on (m.setting_id = s.id)" +
                "  JOIN user2movie u2m on (m.id = u2m.movie_id)" +
                "  JOIN user u on (u2m.user_id = u.id)" +
                "  WHERE u.username = ?;", movieMapper, username);

        movies.forEach(m -> mapMovieTables(m));
        return movies;
    }

    public void mapMovieTables(Movie movie) {
        long movieId = movie.getId();
        movie.setGenres(getGenresForMovie(movieId));
        movie.setMainActors(getActorsForMovie(movieId));
        movie.setActivityTypes(getActivityTypesForMovie(movieId));
    }
}
