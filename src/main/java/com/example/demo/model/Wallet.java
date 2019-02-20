package com.example.demo.model;

public class Wallet {

    private long id;
    private long cash;
    private long card;
    private User user;
    private boolean deleted;

    public Wallet() {
    }

    public Wallet(long id, long cash, long card, User user) {
        this.id = id;
        this.cash = cash;
        this.card = card;
        this.user = user;
        this.deleted = false;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", cash=" + cash +
                ", card=" + card +
                ", user=" + user +
                ", deleted=" + deleted +
                '}';
    }
}
