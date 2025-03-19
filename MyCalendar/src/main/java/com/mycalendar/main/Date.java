package com.mycalendar.main;

import java.time.LocalDateTime;

public record Date(LocalDateTime start, LocalDateTime end) {
    Date(LocalDateTime start, long nbMinutes) {
        this(start, start.plusMinutes(nbMinutes));
    }
}
