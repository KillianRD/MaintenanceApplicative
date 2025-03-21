package com.mycalendar.model;

import com.mycalendar.event.EventType;
import com.mycalendar.main.Date;
import com.mycalendar.main.DureeEvent;
import com.mycalendar.main.Proprietaire;
import com.mycalendar.main.Titre;

import java.time.LocalDateTime;

public class Periodique extends Event {
    private final int frequenceJours;

    public Periodique(Titre title, Proprietaire proprietaire, Date date, DureeEvent dureeMinutes, int frequenceJours) {
        super(EventType.PERIODIQUE, title, proprietaire, date, dureeMinutes);

        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        if (date.start().isAfter(fin)) return false;
        if (date.start().isBefore(debut)) {
            long joursDepuisDebut = java.time.Duration.between(date.start(), debut).toDays();
            return joursDepuisDebut % frequenceJours == 0;
        }
        return true;
    }

    @Override
    public boolean conflitAvec(Event autre) {
        return false;
    }
}
