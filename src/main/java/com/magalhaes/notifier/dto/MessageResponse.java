package com.magalhaes.notifier.dto;

import com.magalhaes.notifier.entity.Message;
import com.magalhaes.notifier.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class MessageResponse {

    Message message;
    Map<String, Set<String>> notificationsPerUser;
}
