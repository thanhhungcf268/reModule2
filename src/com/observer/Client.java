package com.observer;

public class Client {
    public static void main(String[] args) {
        AccountService accountService = new AccountService("1.1.1.1", "admin@gmail.com");
        accountService.attach(new Logger());
        accountService.attach(new Mail());
        accountService.login();
        accountService.notifyAllObserver();
    }
}
