package com.magalhaes.notifier.service;

import com.magalhaes.notifier.dto.MessageRequest;
import com.magalhaes.notifier.dto.MessageResponse;
import com.magalhaes.notifier.entity.Message;
import com.magalhaes.notifier.exception.NotFoundException;
import com.magalhaes.notifier.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MessageRepository repository;

    public Message saveMessage(MessageRequest messageRequest) {
        return repository.save(processMessage(messageRequest));
    }

    public List<MessageResponse> findAllMessages() {
        List<MessageResponse> responses = new ArrayList<>();
        repository.findAll().forEach(message -> {
            responses.add(buildResponse(message));
        });

        return responses;
    }

    public MessageResponse findMessageById(Long id) {
        return buildResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("No message found for id:" + id)));
    }

    public Message processMessage(MessageRequest message) {
        Message processedMessage = new Message();
        processedMessage.setMessage(categoryService.defineMessageCategory(message.getMessage(), message.getCategory()));
        processedMessage.setCategory(message.getCategory());
        processedMessage.setNotifiedUsers(userService.findUsersByCategoryType(message.getCategory()));
        processedMessage.setTimestamp(Timestamp.from(Instant.now()));
        return processedMessage;
    }

    public MessageResponse buildResponse(Message message) {
        MessageResponse response = new MessageResponse();
        response.setMessage(message);
        response.setNotificationsPerUser(notificationService.notifyUsers(message));
        return response;
    }
}
