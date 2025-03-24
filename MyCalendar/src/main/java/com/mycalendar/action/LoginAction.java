package com.mycalendar.action;

import com.mycalendar.service.UserManager;
import com.mycalendar.ui.ConsoleUI;

import java.util.Scanner;

public class LoginAction implements Action {
    private final UserManager userManager;
    private final Scanner scanner;
    private final ConsoleUI ui;

    public LoginAction(UserManager userManager, Scanner scanner, ConsoleUI ui) {
        this.userManager = userManager;
        this.scanner = scanner;
        this.ui = ui;
    }

    @Override
    public void execute() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        if (userManager.login(username, password)) {
            ui.switchToMainMenu();
        } else {
            System.out.println("Identifiants incorrects.");
        }
    }

    @Override
    public String getDescription() {
        return "Se connecter";
    }
}