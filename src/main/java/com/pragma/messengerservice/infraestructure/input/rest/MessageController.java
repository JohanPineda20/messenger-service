package com.pragma.messengerservice.infraestructure.input.rest;

import com.pragma.messengerservice.application.dto.MessageRequest;
import com.pragma.messengerservice.application.handler.IMessageHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final IMessageHandler messageHandler;
    @PostMapping
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public ResponseEntity<Void> sendMessage(@Valid @RequestBody MessageRequest messageRequest){
        messageHandler.sendMessage(messageRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
