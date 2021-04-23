package com.gruppe4.boredoom.backend.spring.model.enums;

public enum ActivityType {

    CALM("ruhig"),
    ACTION("actionreich"),
    SCARY("gruselig"),
    DRAMATIC("dramatisch"),
    HUMOROUS("humorvoll"),
    EXCITING("spannend"),
    EDUCATIONAL("lehrreich");

    private String name;

    ActivityType(String name) {
        this.name = name;
    }
}
