package com.pragma.messengerservice.domain.api;

import com.pragma.messengerservice.domain.model.MessageModel;

public interface IMessageServicePort {
    void sendMessage(MessageModel messageModel);
}
