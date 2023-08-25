package com.magalhaes.notifier.strategy;

import com.magalhaes.notifier.model.User;

public class EmailNotification implements NotificationStrategy{

    private final String EMAIL_MESSAGE = " has been notified through EMAIL.";
    @Override
    public String process(User user) {
        return user.getName().concat(EMAIL_MESSAGE);
    }
}
