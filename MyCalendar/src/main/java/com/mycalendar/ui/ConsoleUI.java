package com.mycalendar.ui;

import com.mycalendar.action.Action;
import com.mycalendar.action.ActionFactory;
import com.mycalendar.service.CalendarManager;
import com.mycalendar.service.UserManager;

import java.util.Scanner;

public class ConsoleUI {
    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final Scanner scanner;
    private final ActionFactory actionFactory;

    private enum MenuState {
        LOGIN,
        MAIN
    }

    private MenuState currentState;

    public ConsoleUI(CalendarManager calendarManager, UserManager userManager) {
        this.calendarManager = calendarManager;
        this.userManager = userManager;
        this.scanner = new Scanner(System.in);
        this.actionFactory = new ActionFactory(calendarManager, userManager, this, scanner);
        this.currentState = MenuState.LOGIN;
    }

    public void start() {
        boolean running = true;

        while (running) {
            switch (currentState) {
                case LOGIN:
                    displayLoginMenu();
                    String loginChoice = scanner.nextLine();
                    if (loginChoice.equals("exit")) {
                        running = false;
                    } else {
                        Action loginAction = actionFactory.getLoginAction(loginChoice);
                        loginAction.execute();
                    }
                    break;
                case MAIN:
                    displayMainMenu();
                    String mainChoice = scanner.nextLine();
                    if (mainChoice.equals("exit")) {
                        running = false;
                    } else {
                        Action mainAction = actionFactory.getMainAction(mainChoice);
                        mainAction.execute();

                        // Si l'utilisateur s'est déconnecté
                        if (!userManager.isLoggedIn()) {
                            switchToLoginMenu();
                        }
                    }
                    break;
            }
        }

        scanner.close();
    }

    private void displayLoginMenu() {
        System.out.println(AsciiManager.generateLogo());
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        System.out.println("Tapez 'exit' pour quitter");
        System.out.print("Choix : ");
    }

    private void displayMainMenu() {
        System.out.println("\nBonjour, " + userManager.getCurrentUser().getUsername());
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Se déconnecter");
        System.out.println("Tapez 'exit' pour quitter");
        System.out.print("Votre choix : ");
    }

    public void switchToMainMenu() {
        currentState = MenuState.MAIN;
    }

    public void switchToLoginMenu() {
        currentState = MenuState.LOGIN;
    }
}
