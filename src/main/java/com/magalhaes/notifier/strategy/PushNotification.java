package com.magalhaes.notifier.strategy;

import com.magalhaes.notifier.model.User;

public class PushNotification implements NotificationStrategy{

    private final String PUSH_MESSAGE = " has been notified through PUSH.";
    @Override
    public String process(User user) {
        return user.getName().concat(PUSH_MESSAGE);
    }
}
