package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Genre;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();

    List<ActivityType> getActivityTypesForMovie(long id);

    List<Genre> getGenresForBook(long id);

    List<Book> getBooksForUser(String username);
}
