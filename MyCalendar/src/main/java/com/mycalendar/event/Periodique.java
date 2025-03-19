package com.mycalendar.event;

import java.time.LocalDateTime;

public class Periodique extends Event {
    private final int frequenceJours;

    public Periodique(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours) {
        super(EventType.PERIODIQUE, title, proprietaire, dateDebut, dureeMinutes);

        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
