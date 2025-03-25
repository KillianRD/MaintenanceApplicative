package com.mycalendar.model;

import java.util.ArrayList;
import java.util.List;

public class Events {
    List<Event> events;

    public Events() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(Event event) {
        this.events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }
}
