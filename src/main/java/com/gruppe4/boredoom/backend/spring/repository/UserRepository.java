package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.error.MediaSaveException;
import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
import com.gruppe4.boredoom.backend.spring.model.user.User;

import java.util.List;

public interface UserRepository {

    User findUserByUsername(String username);

    List<User> getAllUser();

    void saveUser(User user);

    boolean existsByUsername(String username);

    List<Book> findUserBooksByUsername(String username);

    List<Movie> findUserMoviesByUsername(String username);

    List<Media> findFavoritesByUsername(String username);

    void saveFavoriteBook(long bookId, long userId) throws MediaSaveException;

    void saveFavoriteMovie(long bookId, long userId) throws MediaSaveException;

    void saveFavoriteMedia(long mediaId, MediaType mediaType, long userId) throws MediaSaveException;

    void deleteFavoriteMedia(long mediaId, MediaType mediaType, long userId) throws MediaSaveException;

    void deleteFavoriteBook(long userId, long bookId) throws MediaSaveException;

    void deleteFavoritMovie(long userId, long bookId) throws MediaSaveException;
}
