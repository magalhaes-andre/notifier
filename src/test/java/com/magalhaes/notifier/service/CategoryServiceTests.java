package com.magalhaes.notifier.service;

import com.magalhaes.notifier.type.CategoryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    private CategoryService service;

    @Test
    public void defineMessageCategoryProcessesToCorrectMessage() {
        CategoryType type = CategoryType.FINANCE;
        String message = "test message";
        String result = service.defineMessageCategory(message, type);
        assertTrue(result.toLowerCase().contains(type.name().toLowerCase()));
    }
}
