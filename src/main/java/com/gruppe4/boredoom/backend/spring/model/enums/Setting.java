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

    public static Setting fromString(String text) {
        for (Setting setting : Setting.values()) {
            if (setting.name.equalsIgnoreCase(text)) {
                return setting;
            }
        }
        return null;
    }
}
