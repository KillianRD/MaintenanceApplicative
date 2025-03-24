package com.mycalendar.action;

import com.mycalendar.service.UserManager;

import java.util.Scanner;

public class RegisterAction implements Action {
    private final UserManager userManager;
    private final Scanner scanner;

    public RegisterAction(UserManager userManager, Scanner scanner) {
        this.userManager = userManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        String repeatPassword = scanner.nextLine();

        if (!password.equals(repeatPassword)) {
            System.out.println("Les mots de passe ne correspondent pas...");
            return;
        }

        if (userManager.register(username, password)) {
            System.out.println("Compte créé avec succès.");
            // Login automatiquement
            userManager.login(username, password);
        } else {
            System.out.println("Nom d'utilisateur déjà pris.");
        }
    }

    @Override
    public String getDescription() {
        return "Créer un compte";
    }
}
