package com.magalhaes.notifier.service;

import com.magalhaes.notifier.model.User;
import com.magalhaes.notifier.strategy.CategoryStrategy;
import com.magalhaes.notifier.type.CategoryType;
import com.magalhaes.notifier.type.NotificationType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.addAll(Arrays.asList(new User("First User", "first.user@gmail.com", "555-444", new HashSet<>(Arrays.asList(CategoryType.SPORTS)), new HashSet<>(Arrays.asList(NotificationType.SMS))),
                new User("Second User", "second.user@gmail.com", "555-444", new HashSet<>(Arrays.asList(CategoryType.FILMS, CategoryType.SPORTS)), new HashSet<>(Arrays.asList(NotificationType.SMS, NotificationType.PUSH))),
                new User("Third User", "third.user@gmail.com", "555-444", new HashSet<>(Arrays.asList(CategoryType.SPORTS, CategoryType.FINANCE)), new HashSet<>(Arrays.asList(NotificationType.MAIL))),
                new User("Fourth User", "fourth.user@gmail.com", "555-444", new HashSet<>(Arrays.asList(CategoryType.FINANCE)), new HashSet<>(Arrays.asList(NotificationType.SMS))),
                new User("Fifth User", "fifth.user@gmail.com", "555-444", new HashSet<>(Arrays.asList(CategoryType.FINANCE)), new HashSet<>(Arrays.asList(NotificationType.PUSH))),
                new User("Sixth User", "sixth.user@gmail.com", "555-444", new HashSet<>(Arrays.asList(CategoryType.SPORTS, CategoryType.FILMS)), new HashSet<>(Arrays.asList(NotificationType.MAIL, NotificationType.SMS, NotificationType.PUSH)))));
    }

    public Set<User> findUsersByCategoryType(CategoryType category) {
        Set<User> resultingUsers = new HashSet<>();
        users.forEach(user -> {
            if (user.getCategories().contains(category))
                resultingUsers.add(user);
        });

        return resultingUsers;
    }
}
