package com.pragma.messengerservice.domain.spi;

import com.pragma.messengerservice.domain.model.MessageModel;

public interface IMessageMessengerPort {
    void sendMessage(MessageModel messageModel);
}
