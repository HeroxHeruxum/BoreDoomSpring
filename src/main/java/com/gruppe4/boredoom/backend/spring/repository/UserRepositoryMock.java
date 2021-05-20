package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.error.MediaSaveException;
import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
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

    @Override
    public void saveFavoriteBook(long bookId, long userId) throws MediaSaveException {

    }

    @Override
    public void saveFavoriteMovie(long bookId, long userId) throws MediaSaveException {

    }

    @Override
    public void saveFavoriteMedia(long mediaId, MediaType mediaType, long id) throws MediaSaveException {

    }

    @Override
    public void deleteFavoriteMedia(long mediaId, MediaType mediaType, long userId) throws MediaSaveException {

    }

    @Override
    public void deleteFavoriteBook(long userId, long bookId) throws MediaSaveException {

    }

    @Override
    public void deleteFavoritMovie(long userId, long bookId) throws MediaSaveException {

    }

    private User generateMockUser(String username) {
        return new User(Long.parseLong(username), username, "test@test.de", "123", new Date(), Collections.emptyList());
    }

    private List<User> generateUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(generateMockUser(String.valueOf(i)));
        }
        return users;
    }
}
