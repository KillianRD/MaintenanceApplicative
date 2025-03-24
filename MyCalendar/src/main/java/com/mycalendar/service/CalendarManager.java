package com.mycalendar.service;

import com.mycalendar.model.Event;
import com.mycalendar.model.main.Events;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void ajouterEvent(Event e) {
        for (Event event : events.getEvents()) {
            if (conflit(event, e)) {
                System.out.println("Vous ne pouvez pas ajouter un événement sur un autre événement");
                return;
            }
        }

        events.ajouterEvent(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return events.getEvents().stream()
                .filter(e -> e.estDansPeriode(debut, fin))
                .toList();
    }

    public boolean conflit(Event e1, Event e2) {
        return e1.conflitAvec(e2);
    }

    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }

    public void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }
}