package com.pragma.messengerservice.infraestructure.out.messenger;

import com.pragma.messengerservice.domain.model.MessageModel;
import com.pragma.messengerservice.domain.spi.IMessageMessengerPort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;

public class TwilioMessengerAdapter implements IMessageMessengerPort {
    @Value("${TWILIO_ACCOUNT_SID}")
    private String TWILIO_ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    private String TWILIO_AUTH_TOKEN;
    @Value("${TWILIO_PHONE_NUMBER}")
    private String TWILIO_PHONE_NUMBER;
    @Override
    public void sendMessage(MessageModel messageModel) {
        Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(messageModel.getCellphone()),
                        new com.twilio.type.PhoneNumber(TWILIO_PHONE_NUMBER),
                        messageModel.getMessage())
                .create();

        System.out.println(message.getSid());
    }
}
