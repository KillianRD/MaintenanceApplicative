package com.mycalendar.action;

import com.mycalendar.service.CalendarManager;

public class ViewAllEventsAction implements Action {
    private final CalendarManager calendarManager;

    public ViewAllEventsAction(CalendarManager calendarManager) {
        this.calendarManager = calendarManager;
    }

    @Override
    public void execute() {
        calendarManager.afficherEvenements();
    }

    @Override
    public String getDescription() {
        return "Afficher TOUS les événements";
    }
}