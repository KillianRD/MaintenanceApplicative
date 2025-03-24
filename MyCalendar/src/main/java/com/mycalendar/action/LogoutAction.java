package com.mycalendar.action;

import com.mycalendar.service.UserManager;

public class LogoutAction implements Action {
    private final UserManager userManager;

    public LogoutAction(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.logout();
    }

    @Override
    public String getDescription() {
        return "Déconnexion";
    }
}
