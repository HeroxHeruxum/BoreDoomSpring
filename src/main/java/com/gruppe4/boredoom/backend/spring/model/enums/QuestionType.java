package com.gruppe4.boredoom.backend.spring.model.enums;

public enum QuestionType {

    MULTIPLE_CHOICE("Mehrfachauswahl") ,
    SLIDER("Slider"),
    SINGLE_CHOICE("Einfachauswahl");

    private String name;

    QuestionType(String name) {
        this.name = name;
    }

    public static QuestionType fromString(String text) {
        for (QuestionType questionType : QuestionType.values()) {
            if (questionType.name.equalsIgnoreCase(text)) {
                return questionType;
            }
        }
        return null;
    }
}
