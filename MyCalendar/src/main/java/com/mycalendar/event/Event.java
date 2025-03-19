package com.mycalendar.event;

import com.mycalendar.main.Date;
import com.mycalendar.main.DureeEvent;
import com.mycalendar.main.Proprietaire;
import com.mycalendar.main.Titre;

public abstract class Event {
    protected EventType type;
    protected Titre title;
    protected Proprietaire proprietaire;
    protected Date date;
    protected DureeEvent dureeMinutes;

    public Event(EventType type, Titre title, Proprietaire proprietaire, Date date, DureeEvent dureeMinutes) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.date = date;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();
}