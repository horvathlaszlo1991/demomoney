package com.example.demo.model;

public class Response {

    private String message;
    private boolean ok;

    public Response(String message, boolean ok) {
        this.message = message;
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public boolean isOk() {
        return ok;
    }
}
