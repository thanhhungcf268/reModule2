package com.observer;

public class Logger implements Observer {
    @Override
    public void update(User user) {
        if (user.getStatus().equals("LOGIN")) {
            System.out.println("Logger đã được ghi lại của " + user.getEmail() +
                    " có địa chỉ ip là " + user.getIp());
        }
    }
}
