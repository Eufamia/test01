package com.enity;

public class User {
    private Integer id;
    private String username;
    private String passwords;
    private String email;

    public User() {
    }

    public User(Integer id, String username, String passwords, String email) {
        this.id = id;
        this.username = username;
        this.passwords = passwords;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
