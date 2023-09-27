package com.pragma.messengerservice.domain.usecase;

import com.pragma.messengerservice.domain.api.IMessageServicePort;
import com.pragma.messengerservice.domain.model.MessageModel;
import com.pragma.messengerservice.domain.spi.IMessageMessengerPort;

public class MessageUseCase implements IMessageServicePort {

    private final IMessageMessengerPort messageMessengerPort;

    public MessageUseCase(IMessageMessengerPort messageMessengerPort) {
        this.messageMessengerPort = messageMessengerPort;
    }

    @Override
    public void sendMessage(MessageModel messageModel) {
        messageMessengerPort.sendMessage(messageModel);
    }
}
