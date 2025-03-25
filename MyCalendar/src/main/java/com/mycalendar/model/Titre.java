package com.mycalendar.model;

public record Titre(String title) {
    public Titre {
        if (title.isEmpty() || title.isBlank()) {
            throw new IllegalArgumentException("Title shouldn't be blank or empty");
        }
    }
}
