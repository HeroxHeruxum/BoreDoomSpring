package com.gruppe4.boredoom.backend.spring.model.enums;

public enum QuestionType {

    MULTIPLE_CHOICE("Mehrfachauswahl"),
    SLIDER("Slider"),
    SINGLE_CHOICE("Einfachauswahl");

    private String name;

    QuestionType(String name) {
        this.name = name;
    }
}
