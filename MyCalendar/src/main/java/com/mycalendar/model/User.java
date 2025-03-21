package com.mycalendar.model;

public class User {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
