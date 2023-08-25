package com.magalhaes.notifier.service;

import com.magalhaes.notifier.model.User;
import com.magalhaes.notifier.type.CategoryType;
import com.magalhaes.notifier.type.NotificationType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class NotificationServiceTests {

    @Autowired
    private NotificationService service;

    @Test
    public void extractNotificationsOnlyAddNotificationsThatExistsInTheUser() {
        NotificationType notUsedNotificationType = NotificationType.MAIL;
        User user = new User("Test User", "test.mail@mail.com", "0000", new HashSet<>(Arrays.asList(CategoryType.SPORTS)), new HashSet<>(Arrays.asList(NotificationType.SMS, NotificationType.PUSH)));
        Set<String> result = service.extractNotifications(user);
        result.iterator().forEachRemaining(phrase ->
                assertFalse(phrase.contains(notUsedNotificationType.name())));
    }

}
