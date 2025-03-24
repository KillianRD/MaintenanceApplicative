package com.mycalendar.utils;

import java.util.Scanner;

public class InputValidator {
    public static int readInt(Scanner scanner, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("La valeur doit être entre " + min + " et " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide");
            }
        }
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            } else {
                System.out.println("La valeur ne peut pas être vide");
            }
        }
    }
}
