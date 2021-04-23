package com.gruppe4.boredoom.backend.spring.model.enums;

public enum Setting {

    FANTASY("Fantasy"),
    PRESENT("Gegenwart"),
    FUTURE("Zukunft"),
    HISTORIC("Geschichte");

    private String name;

    Setting(String name) {
        this.name = name;
    }
}
