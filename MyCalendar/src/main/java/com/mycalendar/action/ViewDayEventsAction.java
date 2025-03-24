package com.mycalendar.action;

import com.mycalendar.service.CalendarManager;
import com.mycalendar.utils.InputValidator;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ViewDayEventsAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public ViewDayEventsAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        int anneeJour = InputValidator.readInt(scanner, "Année (AAAA) : ", 2000, 2100);
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = InputValidator.readInt(scanner, "Mois (1-12) : ", 1, 12);
        int jour = InputValidator.readInt(scanner, "Jour (1-31) : ", 1, 31);

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        calendarManager.afficherListe(calendarManager.eventsDansPeriode(debutJour, finJour));
    }

    @Override
    public String getDescription() {
        return "Afficher les événements d'un jour";
    }
}
