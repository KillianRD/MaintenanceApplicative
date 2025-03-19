package com.mycalendar.event;

import java.time.LocalDateTime;

public class RdvPersonnel extends Event {
    public RdvPersonnel(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        super(EventType.RDV_PERSONNEL, title, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
