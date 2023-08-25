package com.magalhaes.notifier.dto;

import com.magalhaes.notifier.type.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageRequest {

    private String message;
    private CategoryType category;
}
