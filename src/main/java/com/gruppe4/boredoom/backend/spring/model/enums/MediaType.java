package com.gruppe4.boredoom.backend.spring.model.enums;

public enum MediaType {

    BOOK("Buch"),
    MOVIE("Film");

    private String name;

    MediaType(String name) {
        this.name = name;
    }

    public static MediaType fromString(String text) {
        for (MediaType mediaType : MediaType.values()) {
            if (mediaType.name.equalsIgnoreCase(text)) {
                return mediaType;
            }
        }
        return null;
    }
}
