package com.mycalendar;

import com.mycalendar.event.Event;
import com.mycalendar.event.Events;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void ajouterEvent(Event e) {
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
}