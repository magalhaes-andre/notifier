package com.magalhaes.notifier.controller;

import com.magalhaes.notifier.dto.MessageRequest;
import com.magalhaes.notifier.dto.MessageResponse;
import com.magalhaes.notifier.entity.Message;
import com.magalhaes.notifier.exception.BadRequestException;
import com.magalhaes.notifier.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    public ResponseEntity<MessageResponse> postMessage(@RequestBody MessageRequest messageRequest) {
        if (validateMessage(messageRequest)) {
            Message processedMessage = service.saveMessage(messageRequest);
            MessageResponse response = service.buildResponse(processedMessage);

            return ResponseEntity.ok(response);
        }

        throw new BadRequestException("There was an issue with the received request: " + messageRequest.toString());
    }

    @GetMapping
    public ResponseEntity<List<MessageResponse>> fetchAllMessages() {
        return ResponseEntity.ok(service.findAllMessages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> findMessageById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findMessageById(id));
    }

    public boolean validateMessage(MessageRequest messageRequest) {
        String message = messageRequest.getMessage();
        String category = String.valueOf(messageRequest.getCategory());
        return message.isEmpty() || message == null && category == null ? false : true;
    }
}
