package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Genre;
import com.gruppe4.boredoom.backend.spring.repository.mapper.BookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private final BookMapper bookMapper;

    public BookRepositoryImpl(JdbcTemplate jdbcTemplate, BookMapper bookMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = jdbcTemplate.query("SELECT b.*, a.full_name, s.setting from book b" +
                "  JOIN author a on (b.author_id = a.id)" +
                "  JOIN setting s on (b.setting_id = s.id);", bookMapper);

        for (Book book : books) {
            mapBookTables(book);
        }

        return books;
    }

    @Override
    public List<ActivityType> getActivityTypesForMovie(long id) {
        List<String> activityTypesStr = jdbcTemplate.queryForList("SELECT a.activity_type from activity_type a " +
                "  JOIN book2activity_type b2a on (a.id = b2a.activity_type_id)" +
                "  JOIN book b on (b.id = b2a.book_id)" +
                "  WHERE b.id = ?;", String.class, id);

        List<ActivityType> activityTypes = new ArrayList<>();

        activityTypesStr.forEach(s -> activityTypes.add(ActivityType.fromString(s)));

        return activityTypes;
    }

    @Override
    public List<Genre> getGenresForBook(long id) {
        List<String> genresStr = jdbcTemplate.queryForList("SELECT bg.genre from genre bg" +
                "  JOIN book2book_genre b2b on (bg.id = b2b.book_genre_id)" +
                "  JOIN book b on (b.id = b2b.book_id)" +
                "  WHERE b.id = ?;", String.class, id);

        List<Genre> bookGenres = new ArrayList<>();

        genresStr.forEach(s -> bookGenres.add(Genre.fromString(s)));

        return bookGenres;
    }

    @Override
    public List<Book> getBooksForUser(String username) {
        List<Book> books = jdbcTemplate.query("SELECT b.*, a.full_name, s.setting from book b" +
                "  JOIN author a on (b.author_id = a.id)" +
                "  JOIN setting s on (b.setting_id = s.id)" +
                "  JOIN user2book u2b on (b.id = u2b.book_id)" +
                "  JOIN user u on (u2b.user_id = u.id)" +
                "  WHERE u.username = ?;", bookMapper, username);

        books.forEach(b -> mapBookTables(b));

        return books;
    }

    public void mapBookTables(Book book) {
        book.setGenres(getGenresForBook(book.getId()));
        book.setActivityTypes(getActivityTypesForMovie(book.getId()));
    }
}
