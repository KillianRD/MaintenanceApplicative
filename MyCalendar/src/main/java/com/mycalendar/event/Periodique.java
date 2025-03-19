package com.mycalendar.event;

import com.mycalendar.main.Date;
import com.mycalendar.main.DureeEvent;
import com.mycalendar.main.Proprietaire;
import com.mycalendar.main.Titre;

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
}
