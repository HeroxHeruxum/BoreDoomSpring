package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserRepositoryMock implements UserRepository {

    List<User> users = generateUserList();

    @Override
    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> findUserBooksByUsername(String username) {
        return null;
    }

    @Override
    public List<Movie> findUserMoviesByUsername(String username) {
        return null;
    }

    @Override
    public List<Media> findFavoritesByUsername(String username) {
        return null;
    }

    private User generateMockUser(String id) {
        return new User(id, "test@test.de", "123", new Date(), Collections.emptyList());
    }

    private List<User> generateUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(generateMockUser(String.valueOf(i)));
        }
        return users;
    }
}
