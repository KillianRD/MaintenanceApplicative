package com.mycalendar.event;

import java.time.LocalDateTime;

public abstract class Event {
    protected EventType type;
    protected String title;
    protected String proprietaire;
    protected LocalDateTime dateDebut;
    protected int dureeMinutes;

    public Event(EventType type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();
}