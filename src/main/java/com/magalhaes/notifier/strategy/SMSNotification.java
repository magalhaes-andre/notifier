package com.magalhaes.notifier.strategy;

import com.magalhaes.notifier.model.User;

public class SMSNotification implements NotificationStrategy{

    private final String SMS_MESSAGE = " has been notified through SMS.";
    @Override
    public String process(User user) {
        return user.getName().concat(SMS_MESSAGE);
    }
}
