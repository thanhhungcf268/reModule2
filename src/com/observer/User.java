package com.observer;

public class User {
    private String ip;
    private String email;
    String status;

    public User() {
    }

    public User(String ip, String email) {
        this.ip = ip;
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
