package com.mycalendar.model;

import java.time.LocalDateTime;

public class RdvPersonnel extends Event {
    public RdvPersonnel(Titre title, Proprietaire proprietaire, Date date, DureeEvent dureeMinutes) {
        super(EventType.RDV_PERSONNEL, title, proprietaire, date, dureeMinutes);
    }

    @Override
    public String description() {
        return "RDV : " + title.title() + " à " + date.start().toString();
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
