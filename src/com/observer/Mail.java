package com.observer;

public class Mail implements Observer {
    @Override
    public void update(User user) {
        if (user.getStatus().equals("LOGIN")) {
            System.out.println("Email đã được gửi đến " + user.getEmail() +
                    " có địa chỉ ip là " + user.getIp());
        }
    }
}
