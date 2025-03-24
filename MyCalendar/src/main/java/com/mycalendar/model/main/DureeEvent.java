package com.mycalendar.model.main;

public record DureeEvent (int time) {
    public DureeEvent {
        if(time <= 0){
            throw new IllegalArgumentException("The time (in minutes) of an event shouldn't be negative or null");
        }
    }
}
