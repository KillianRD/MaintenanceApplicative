package com.mycalendar.event;

import java.time.LocalDateTime;
import java.util.List;

public class Reunion extends Event {
    private String lieu;
    private List<String> participants;

    public Reunion(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, List<String> participants) {
        super(EventType.REUNION, title, proprietaire, dateDebut, dureeMinutes);

        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants.stream().toString();
    }
}
