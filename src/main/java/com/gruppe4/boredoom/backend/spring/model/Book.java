package com.gruppe4.boredoom.backend.spring.model;

import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.BookGenre;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;

import java.util.List;

public class Book extends Media {

    private String author;
    private List<BookGenre> bookGenre;
    private Integer pageCount;

    public Book() {}

    public Book(String author, List<BookGenre> bookGenre, int pageCount) {
        this.author = author;
        this.bookGenre = bookGenre;
        this.pageCount = pageCount;
    }

    public Book(long id, String name, String description, String imageUrl, int publishingYear, int minAge, int personCountMin,
            int personCountMax, int durationMin, int durationMax, List<ActivityType> activityTypes, Setting setting, String author,
            List<BookGenre> bookGenre, int pageCount) {

        super(id, name, description, imageUrl, publishingYear, minAge, personCountMin, personCountMax, durationMin, durationMax,
                activityTypes, setting);
        this.author = author;
        this.bookGenre = bookGenre;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookGenre> getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(List<BookGenre> bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
