package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

@Component
public class MovieMapper extends MediaMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int i) throws SQLException {

        Movie movie = new Movie();
        mapMedia(movie, rs);

        movie.setMainActors(Collections.emptyList()); // Needs to be queried separately
        movie.setMovieGenre(Collections.emptyList());  // Needs to be queried separately
        movie.setDirector(rs.getString("first_name")); //TODO: fullname
        movie.setDuration(rs.getInt("duration"));

        return movie;
    }
}
