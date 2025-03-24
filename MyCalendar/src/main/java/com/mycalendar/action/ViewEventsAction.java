package com.mycalendar.action;

import com.mycalendar.service.CalendarManager;

import java.util.Map;
import java.util.Scanner;

public class ViewEventsAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;
    private final Map<String, Action> viewActions;

    public ViewEventsAction(CalendarManager calendarManager, Scanner scanner, Map<String, Action> viewActions) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
        this.viewActions = viewActions;
    }

    @Override
    public void execute() {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");

        String choice = scanner.nextLine();
        Action viewAction = viewActions.get(choice);
        if (viewAction != null) {
            viewAction.execute();
        } else {
            System.out.println("Choix invalide. Retour au menu principal.");
        }

    }

    @Override
    public String getDescription() {
        return "Voir les événements";
    }
}
