package com.mycalendar.main;

import java.time.LocalDateTime;

public record Date(LocalDateTime start, LocalDateTime end) {
    public Date(LocalDateTime start, long nbMinutes) {
        this(start, start.plusMinutes(nbMinutes));
    }
}
