package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.BookGenre;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();

    List<ActivityType> getActivityTypesForMovie(long id);

    List<BookGenre> getGenresForBook(long id);

    List<Book> getBooksForUser(String username);
}
