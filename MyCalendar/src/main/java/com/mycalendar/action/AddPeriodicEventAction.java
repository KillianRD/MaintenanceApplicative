package com.mycalendar.action;

import com.mycalendar.model.Periodique;
import com.mycalendar.model.Date;
import com.mycalendar.model.DureeEvent;
import com.mycalendar.model.Proprietaire;
import com.mycalendar.model.Titre;
import com.mycalendar.service.CalendarManager;
import com.mycalendar.service.UserManager;
import com.mycalendar.utils.InputValidator;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddPeriodicEventAction implements Action {
    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final Scanner scanner;

    public AddPeriodicEventAction(CalendarManager calendarManager, UserManager userManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.userManager = userManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();

        int annee = InputValidator.readInt(scanner, "Année (AAAA) : ", 2000, 2100);
        int mois = InputValidator.readInt(scanner, "Mois (1-12) : ", 1, 12);
        int jour = InputValidator.readInt(scanner, "Jour (1-31) : ", 1, 31);
        int heure = InputValidator.readInt(scanner, "Heure début (0-23) : ", 0, 23);
        int minute = InputValidator.readInt(scanner, "Minute début (0-59) : ", 0, 59);
        int duree = InputValidator.readInt(scanner, "Durée (en minutes) : ", 1, 1440);
        int frequance = InputValidator.readInt(scanner, "Frequence de l'évent", 1, 31);

        calendarManager.ajouterEvent(
                new Periodique(
                        new Titre(titre),
                        new Proprietaire(userManager.getCurrentUser().getUsername()),
                        new Date(LocalDateTime.of(annee, mois, jour, heure, minute), duree),
                        new DureeEvent(duree),
                        frequance
                )
        );

        System.out.println("Événement ajouté.");
    }

    @Override
    public String getDescription() {
        return "Ajouter d'un événement périodique";
    }
}
