package com.tests.domains;

public class User {
    private final String email;
    private final String password;

    private User() {
        this.email = System.getenv("email");
        this.password = System.getenv("password");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static User getUser() {
        return new User();
    }
}
