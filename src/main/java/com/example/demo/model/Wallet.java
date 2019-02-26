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

    public Wallet(long id, long cash, long card, User user, boolean deleted) {
        this.id = id;
        this.cash = cash;
        this.card = card;
        this.user = user;
        this.deleted = deleted;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", cash=" + cash +
                ", card=" + card +
                ", user=" + user.getName() +
                ", deleted=" + deleted +
                '}';
    }
}
