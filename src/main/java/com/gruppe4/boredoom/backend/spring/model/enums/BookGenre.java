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

    public static BookGenre fromString(String text) {
        for (BookGenre bookGenre : BookGenre.values()) {
            if (bookGenre.name.equalsIgnoreCase(text)) {
                return bookGenre;
            }
        }
        return null;
    }
}