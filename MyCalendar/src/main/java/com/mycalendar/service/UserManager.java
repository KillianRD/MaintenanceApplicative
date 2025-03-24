package com.mycalendar.service;

import com.mycalendar.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private User currentUser;

    public UserManager() {
        this.users = new ArrayList<>();
        this.currentUser = null;
    }

    public void addDefaultUsers() {
        users.add(new User("Roger", "Chat"));
        users.add(new User("Pierre", "KiRouhl"));
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public boolean register(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        users.add(new User(username, password));
        return true;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
