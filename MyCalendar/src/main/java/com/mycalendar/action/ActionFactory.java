package com.mycalendar.action;

import com.mycalendar.service.CalendarManager;
import com.mycalendar.service.UserManager;
import com.mycalendar.ui.ConsoleUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ActionFactory {
    private final Map<String, Action> loginActions = new HashMap<>();
    private final Map<String, Action> mainActions = new HashMap<>();
    private final Map<String, Action> viewActions = new HashMap<>();

    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final ConsoleUI ui;
    private final Scanner scanner;

    public ActionFactory(CalendarManager calendarManager, UserManager userManager, ConsoleUI ui, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.userManager = userManager;
        this.ui = ui;
        this.scanner = scanner;

        initializeActions();
    }

    private void initializeActions() {
        // Login menu actions
        loginActions.put("1", new LoginAction(userManager, scanner, ui));
        loginActions.put("2", new RegisterAction(userManager, scanner));

        // Main menu actions
        mainActions.put("1", new ViewEventsAction(calendarManager, scanner, viewActions));
        mainActions.put("2", new AddPersonalEventAction(calendarManager, userManager, scanner));
        mainActions.put("3", new AddMeetingAction(calendarManager, userManager, scanner));
        mainActions.put("4", new AddPeriodicEventAction(calendarManager, userManager, scanner));
        mainActions.put("5", new LogoutAction(userManager));

        // View events sub-menu actions
        viewActions.put("1", new ViewAllEventsAction(calendarManager));
        viewActions.put("2", new ViewMonthEventsAction(calendarManager, scanner));
        viewActions.put("3", new ViewWeekEventsAction(calendarManager, scanner));
        viewActions.put("4", new ViewDayEventsAction(calendarManager, scanner));
    }

    public Action getLoginAction(String choice) {
        return loginActions.getOrDefault(choice, new Action() {
            @Override
            public void execute() {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }

            @Override
            public String getDescription() {
                return "";
            }
        });
    }


    public Action getMainAction(String choice) {
        return mainActions.getOrDefault(choice, new Action() {
            @Override
            public void execute() {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }

            @Override
            public String getDescription() {
                return "";
            }
        });
    }

    public Action getViewAction(String choice) {
        return viewActions.getOrDefault(choice, new Action() {
            @Override
            public void execute() {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }

            @Override
            public String getDescription() {
                return "";
            }
        });
    }
}
