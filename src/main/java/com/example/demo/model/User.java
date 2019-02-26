package com.example.demo.model;

import java.util.List;

public class User {

    private long id;
    private String name;
    private String email;
    private String password;
    private boolean deleted;
    private UserRole userRole;
    private List<Wallet> wallets;

    public User() {
    }

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.deleted = false;
    }

    public User(long id, String name, String email, String password, boolean deleted, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.deleted = deleted;
        this.userRole = userRole;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void addWallet(Wallet wallet) {
        wallets.add(wallet);
    }

    public void removeWallet(Wallet wallet) {
        wallets.remove(wallet);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", deleted=" + deleted +
                ", userRole=" + userRole +
                '}';
    }
}
