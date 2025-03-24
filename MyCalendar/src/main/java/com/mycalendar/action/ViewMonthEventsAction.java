package com.mycalendar.action;

import com.mycalendar.model.Event;
import com.mycalendar.service.CalendarManager;
import com.mycalendar.utils.InputValidator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ViewMonthEventsAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public ViewMonthEventsAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        int anneeMois = InputValidator.readInt(scanner, "Année (AAAA) : ", 2000, 2100);
        int mois = InputValidator.readInt(scanner, "Mois (1-12) : ", 1, 12);

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        calendarManager.afficherListe(calendarManager.eventsDansPeriode(debutMois, finMois));
    }

    @Override
    public String getDescription() {
        return "Afficher les événements d'un mois";
    }
}
