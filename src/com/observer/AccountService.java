package com.observer;

import java.util.ArrayList;
import java.util.List;

public class AccountService implements Subject {
    private User user;
    private List<Observer> observers = new ArrayList<>();

    public AccountService(String ip, String email) {
        this.user = new User(ip, email);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(user);
        }
    }

    public void changeUserStatus(String status) {
        user.setStatus(status);
    }

    public void login() {
        if (user.getEmail().equals("admin@gmail.com")) {
            changeUserStatus("LOGIN");
        } else {
            changeUserStatus("ERROR");
        }
    }
}
