package com.magalhaes.notifier.strategy;

import com.magalhaes.notifier.entity.Message;

public class FinanceCategory implements CategoryStrategy{

    private final String FINANCE_MESSAGE = "This is a Finance message: ";
    @Override
    public String process(String message) {
        return FINANCE_MESSAGE.concat(message);
    }
}
