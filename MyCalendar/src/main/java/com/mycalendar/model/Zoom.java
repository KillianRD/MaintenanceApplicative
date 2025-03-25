package com.mycalendar.model;

import java.time.LocalDateTime;

public class Zoom extends Event {

    private String lienZoom;

    public Zoom(Titre title, Proprietaire proprietaire, Date date, DureeEvent dureeMinutes, String lienZoom) {
        super(EventType.ZOOM, title, proprietaire, date, dureeMinutes);
        this.lienZoom = lienZoom;
    }

    @Override
    public String description() {
        return "Conférence Zoom : " + title.title() + ", lien = " + lienZoom;
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return !date.start().isBefore(debut) && !date.start().isAfter(fin);
    }

    @Override
    public boolean conflitAvec(Event autre) {
        return date.start().isBefore(autre.getDate().end()) && date.end().isAfter(autre.getDate().start());
    }
}
