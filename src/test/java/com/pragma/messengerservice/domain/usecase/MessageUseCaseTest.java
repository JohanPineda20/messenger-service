package com.pragma.messengerservice.domain.usecase;

import com.pragma.messengerservice.domain.model.MessageModel;
import com.pragma.messengerservice.domain.spi.IMessageMessengerPort;
import com.twilio.exception.ApiException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageUseCaseTest {
    @InjectMocks
    MessageUseCase messageUseCase;
    @Mock
    IMessageMessengerPort messageMessengerPort;

    @Test
    void sendMessage() {
        MessageModel messageModel = new MessageModel();
        doNothing().when(messageMessengerPort).sendMessage(messageModel);

        messageUseCase.sendMessage(messageModel);

        verify(messageMessengerPort, times(1)).sendMessage(messageModel);
    }

    @Test
    void sendMessageApiException() {
        MessageModel messageModel = new MessageModel();
        doThrow(ApiException.class).when(messageMessengerPort).sendMessage(messageModel);

        assertThrows(ApiException.class, () -> messageUseCase.sendMessage(messageModel));

        verify(messageMessengerPort, times(1)).sendMessage(messageModel);
    }
}