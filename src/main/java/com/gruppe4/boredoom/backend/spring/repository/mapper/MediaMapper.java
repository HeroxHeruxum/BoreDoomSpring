package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public abstract class MediaMapper {

    protected void mapMedia(Media media, ResultSet rs) throws SQLException {

        media.setSetting(Setting.fromString(rs.getString("setting")));
        media.setId(rs.getLong("id"));
        media.setDescription(rs.getString("description"));
        media.setName(rs.getString("title"));
        media.setImageUrl(rs.getString("image_url"));
        media.setPublishingYear(rs.getDate("publishing_year").getYear());
        media.setMinAge(rs.getInt("min_age"));
        media.setActivityTypes(Collections.emptyList());// Needs to be queried separately

        if (media instanceof Book) {
            media.setMediaType(MediaType.BOOK);
        } else if (media instanceof Movie) {
            media.setMediaType(MediaType.MOVIE);
        }

        //media.setPersonCountMin();
        //media.setPersonCountMax();
        //media.setDurationMin();
        //media.setDurationMax();
    }
}
