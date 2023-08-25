package com.magalhaes.notifier.service;

import com.magalhaes.notifier.entity.Message;
import com.magalhaes.notifier.model.User;
import com.magalhaes.notifier.strategy.EmailNotification;
import com.magalhaes.notifier.strategy.NotificationStrategy;
import com.magalhaes.notifier.strategy.PushNotification;
import com.magalhaes.notifier.strategy.SMSNotification;
import com.magalhaes.notifier.type.NotificationType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class NotificationService {

    private Set<NotificationStrategy> strategies;
    public Map<String, Set<String>> notifyUsers(Message message) {
        Map<String, Set<String >> notificationsPerUser = new HashMap();
        message.getNotifiedUsers().forEach(user -> {
            notificationsPerUser.put(user.getName(), extractNotifications(user));
        });

        return notificationsPerUser;
    }

    public Set<String> extractNotifications(User user) {
        Set<String> notifications = new HashSet<>();
        strategies = new HashSet<>();
        user.getNotifications().forEach(notification -> {
            if (notification.equals(NotificationType.MAIL))
                strategies.add(new EmailNotification());
            if (notification.equals(NotificationType.SMS))
                strategies.add(new SMSNotification());
            if (notification.equals(NotificationType.PUSH))
                strategies.add(new PushNotification());
        });

        strategies.forEach(strategy -> notifications.add(strategy.process(user)));
        return notifications;
    }
}
