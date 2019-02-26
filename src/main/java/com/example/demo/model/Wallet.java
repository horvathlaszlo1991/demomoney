package com.example.demo.model;

public class Wallet {

    private long id;
    private long cash;
    private long card;
    private long userId;
    private boolean deleted;

    public Wallet() {
    }

    public Wallet(long id, long cash, long card, long userId) {
        this.id = id;
        this.cash = cash;
        this.card = card;
        this.userId = userId;
        this.deleted = false;
    }

    public Wallet(long id, long cash, long card, long userId, boolean deleted) {
        this.id = id;
        this.cash = cash;
        this.card = card;
        this.userId = userId;
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

    public long getUserId() {
        return userId;
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

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", cash=" + cash +
                ", card=" + card +
                ", userId=" + userId +
                ", deleted=" + deleted +
                '}';
    }
}
