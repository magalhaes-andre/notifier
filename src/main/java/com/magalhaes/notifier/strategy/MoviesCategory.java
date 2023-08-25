package com.magalhaes.notifier.strategy;

public class MoviesCategory implements CategoryStrategy{

    private final String MOVIES_MESSAGE = "This is a Movie message: ";
    @Override
    public String process(String message) {
        return MOVIES_MESSAGE.concat(message);
    }
}
