package com.pragma.messengerservice.application.handler.Impl;

import com.pragma.messengerservice.application.dto.MessageRequest;
import com.pragma.messengerservice.application.handler.IMessageHandler;
import com.pragma.messengerservice.domain.api.IMessageServicePort;
import com.pragma.messengerservice.domain.model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageHandlerImpl implements IMessageHandler {

    private final IMessageServicePort messageServicePort;

    @Override
    public void sendMessage(MessageRequest messageRequest) {
        MessageModel  messageModel = new MessageModel(messageRequest.getMessage(), messageRequest.getCellphone());
        messageServicePort.sendMessage(messageModel);
    }
}
