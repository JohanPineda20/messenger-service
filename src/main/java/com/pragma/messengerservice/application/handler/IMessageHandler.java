package com.pragma.messengerservice.application.handler;

import com.pragma.messengerservice.application.dto.MessageRequest;

public interface IMessageHandler {
    void sendMessage(MessageRequest messageRequest);
}
