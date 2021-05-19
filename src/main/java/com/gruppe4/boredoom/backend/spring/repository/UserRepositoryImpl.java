package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.error.MediaSaveException;
import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
import com.gruppe4.boredoom.backend.spring.model.user.User;
import com.gruppe4.boredoom.backend.spring.repository.mapper.UserMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;
    private final BookRepository bookRepository;
    private final MovieRepository movieRepository;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, UserMapper userMapper,
            BookRepository bookRepository,
            MovieRepository movieRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public User findUserByUsername(String username) {

        User user = jdbcTemplate.queryForObject("SELECT * from user u where u.username = ?", userMapper, username);
        user.setFavorites(findFavoritesByUsername(user.getUserName()));

        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = jdbcTemplate.query("SELECT * from user;", userMapper);

        for (User user : users) {
            user.setFavorites(findFavoritesByUsername(user.getUserName()));
        }

        return users;
    }

    @Override
    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO user (username, email, password, registration_date) VALUES (?, ?, ?, ?);",
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getRegistrationDate());
    }

    @Override
    public boolean existsByUsername(String username) {
        Integer i = jdbcTemplate.queryForObject("SELECT COUNT(*) from user u WHERE u.username = ?;", Integer.class, username);
        return i > 0;
    }

    @Override
    public List<Book> findUserBooksByUsername(String username) {
        return bookRepository.getBooksForUser(username);
    }

    @Override
    public List<Movie> findUserMoviesByUsername(String username) {
        return movieRepository.findMoviesForUser(username);
    }

    @Override
    public List<Media> findFavoritesByUsername(String username) {
        List<Media> favorites = new ArrayList<>();

        List<Movie> movies = findUserMoviesByUsername(username);
        List<Book> books = findUserBooksByUsername(username);

        favorites.addAll(movies);
        favorites.addAll(books);

        return favorites;
    }

    @Override
    public void saveFavoriteBook(long bookId, long userId) throws MediaSaveException {
        try {
            jdbcTemplate.update("INSERT INTO user2book (user_id, book_id) VALUES (?, ?);", userId, bookId);
        } catch (DataAccessException e) {
            throw new MediaSaveException("Error while saving book to favorites");
        }
    }

    @Override
    public void saveFavoriteMovie(long movieId, long userId) throws MediaSaveException {

        try {
            jdbcTemplate.update("INSERT INTO user2movie (user_id, movie_id) VALUES (?, ?);", userId, movieId);
        } catch (DataAccessException e) {
            throw new MediaSaveException("Error while saving movie to favorites");
        }
    }

    @Override
    public void saveFavoriteMedia(long mediaId, MediaType mediaType, long userId) throws MediaSaveException {

        switch (mediaType) {
            case BOOK:
                saveFavoriteBook(mediaId, userId);
                break;

            case MOVIE:
                saveFavoriteMovie(mediaId, userId);
                break;
        }
    }

}