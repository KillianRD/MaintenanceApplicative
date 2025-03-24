package com.mycalendar.model;

import com.mycalendar.model.main.EventType;
import com.mycalendar.model.main.Date;
import com.mycalendar.model.main.DureeEvent;
import com.mycalendar.model.main.Proprietaire;
import com.mycalendar.model.main.Titre;

import java.time.LocalDateTime;
import java.util.List;

public class Reunion extends Event {
    private String lieu;
    private List<String> participants;

    public Reunion(Titre title, Proprietaire proprietaire, Date date, DureeEvent dureeMinutes, String lieu, List<String> participants) {
        super(EventType.REUNION, title, proprietaire, date, dureeMinutes);

        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec "
                + String.join(", ", participants);
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
