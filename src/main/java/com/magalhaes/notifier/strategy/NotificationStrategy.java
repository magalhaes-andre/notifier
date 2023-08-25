package com.magalhaes.notifier.strategy;

import com.magalhaes.notifier.model.User;

public interface NotificationStrategy {

    public String process(User user);
}
