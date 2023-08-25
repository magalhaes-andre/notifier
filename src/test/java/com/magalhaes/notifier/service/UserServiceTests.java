package com.magalhaes.notifier.service;

import com.magalhaes.notifier.model.User;
import com.magalhaes.notifier.type.CategoryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService service;

    @Test
    public void findByCategoryReturnsOnlySpecificUsersForCategory() {
        CategoryType type = CategoryType.FILMS;
        Set<User> users = service.findUsersByCategoryType(type);
        assertTrue(users.stream().filter(user -> user.getCategories().contains(type)).findAny().isPresent());
    }
}
