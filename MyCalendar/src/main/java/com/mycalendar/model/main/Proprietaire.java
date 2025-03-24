package com.mycalendar.model.main;

public record Proprietaire(String name) {
    public Proprietaire {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name shouldn't be blank or empty");
        }
    }
}
