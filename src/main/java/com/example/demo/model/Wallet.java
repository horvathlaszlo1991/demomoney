package com.example.demo.model;

public class Wallet {

    private long id;
    private long cash;
    private long card;
    private User user;

    public Wallet(long id, long cash, long card, User user) {
        this.id = id;
        this.cash = cash;
        this.card = card;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public long getCash() {
        return cash;
    }

    public long getCard() {
        return card;
    }

    public User getUser() {
        return user;
    }
}
