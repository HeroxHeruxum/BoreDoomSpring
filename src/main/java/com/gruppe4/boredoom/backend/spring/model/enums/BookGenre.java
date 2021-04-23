package com.gruppe4.boredoom.backend.spring.model.enums;

public enum BookGenre {

    HORROR("Horror"),
    ROMANCE("Liebe"),
    ADVENTURE("Abenteuer"),
    SCIENCE_FICTION("Science-Fiction");

    private String name;

    BookGenre(String name) {
        this.name = name;
    }
}