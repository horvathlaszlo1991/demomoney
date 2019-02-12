package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long id;
    private String name;
    private String email;
    private String password;
    private boolean deleted;
    private List<Wallet> wallets = new ArrayList<>();

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.deleted = false;
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
}
