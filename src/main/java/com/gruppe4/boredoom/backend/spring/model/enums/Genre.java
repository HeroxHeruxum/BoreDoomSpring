package com.gruppe4.boredoom.backend.spring.model.enums;

public enum Genre {

    HORROR("Horror"),
    FANTASY("Fantasy"),
    CRIME("Krimi"),
    ACTION("Action"),
    COMEDY("Comedy"),
    ADVENTURE("Abenteuer");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    public static Genre fromString(String text) {
        for (Genre movieGenre : Genre.values()) {
            if (movieGenre.name.equalsIgnoreCase(text)) {
                return movieGenre;
            }
        }
        return null;
    }
}
