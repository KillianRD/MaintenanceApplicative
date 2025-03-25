package com.mycalendar.model;

import com.mycalendar.model.main.EventType;
import com.mycalendar.model.main.Date;
import com.mycalendar.model.main.DureeEvent;
import com.mycalendar.model.main.Proprietaire;
import com.mycalendar.model.main.Titre;

import java.time.LocalDateTime;

public class Periodique extends Event {
    private final int frequenceJours;

    public Periodique(Titre title, Proprietaire proprietaire, Date date, DureeEvent dureeMinutes, int frequenceJours) {
        super(EventType.PERIODIQUE, title, proprietaire, date, dureeMinutes);

        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title.title() + " tous les " + frequenceJours + " jours";
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
