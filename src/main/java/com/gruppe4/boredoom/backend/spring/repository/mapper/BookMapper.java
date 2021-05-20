package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

@Component
public class BookMapper extends MediaMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {

        Book book = new Book();
        mapMedia(book, rs);

        book.setGenres(Collections.emptyList());  // Needs to be queried separately
        book.setPageCount(rs.getInt("page_count"));
        book.setAuthor(rs.getString("full_name")); //TODO: fullname

        return book;
    }
}
