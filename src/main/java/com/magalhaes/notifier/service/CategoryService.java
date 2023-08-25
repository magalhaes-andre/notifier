package com.magalhaes.notifier.service;

import com.magalhaes.notifier.entity.Message;
import com.magalhaes.notifier.strategy.*;
import com.magalhaes.notifier.type.CategoryType;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryStrategy strategy;
    public String defineMessageCategory(String message, CategoryType category) {
        switch (category) {
            case SPORTS -> strategy = new SportsCategory();
            case FILMS -> strategy = new MoviesCategory();
            case FINANCE -> strategy = new FinanceCategory();
        }

        return strategy.process(message);
    }
}
