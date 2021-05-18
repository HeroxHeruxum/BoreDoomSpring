package com.gruppe4.boredoom.backend.spring.model.enums;

public enum MovieGenre {

    HORROR("Horror"),
    ROMANCE("Liebe"),
    ADVENTURE("Abenteuer"),
    COMEDY("Komödie"),
    SCIENCE_FICTION("Science-Fiction");

    private String name;

    MovieGenre(String name) {
        this.name = name;
    }

    public static MovieGenre fromString(String text) {
        for (MovieGenre movieGenre : MovieGenre.values()) {
            if (movieGenre.name.equalsIgnoreCase(text)) {
                return movieGenre;
            }
        }
        return null;
    }
}
