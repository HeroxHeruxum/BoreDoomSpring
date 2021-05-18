package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
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

}
