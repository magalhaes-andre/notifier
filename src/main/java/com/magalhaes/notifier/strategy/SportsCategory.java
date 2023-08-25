package com.magalhaes.notifier.strategy;

public class SportsCategory implements CategoryStrategy{

    private final String SPORTS_MESSAGE = "This is a Sports message: ";
    @Override
    public String process(String message) {
        return SPORTS_MESSAGE.concat(message);
    }
}
