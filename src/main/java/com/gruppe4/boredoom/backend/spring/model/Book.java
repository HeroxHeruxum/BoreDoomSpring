package com.gruppe4.boredoom.backend.spring.model;

import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;

import java.util.List;

public class Book extends Media {

    private String author;
    private Integer pageCount;

    public Book() {}

    public Book(String author, int pageCount) {
        this.author = author;
        this.pageCount = pageCount;
    }

    public Book(long id, String name, String description, String imageUrl, int publishingYear, int minAge, int personCountMin,
            int personCountMax, int durationMin, int durationMax, List<ActivityType> activityTypes, Setting setting, String author,
            int pageCount) {

        super(id, MediaType.BOOK, name, description, imageUrl, publishingYear, minAge, personCountMin, personCountMax,
                durationMin, durationMax,
                activityTypes, setting);
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
