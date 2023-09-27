package com.pragma.messengerservice.infraestructure.configuration;

import com.pragma.messengerservice.domain.api.IMessageServicePort;
import com.pragma.messengerservice.domain.spi.IMessageMessengerPort;
import com.pragma.messengerservice.domain.usecase.MessageUseCase;
import com.pragma.messengerservice.infraestructure.out.messenger.TwilioMessengerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public IMessageMessengerPort messageMessengerPort(){
        return new TwilioMessengerAdapter();
    }
    @Bean
    public IMessageServicePort messageServicePort(IMessageMessengerPort messageMessengerPort){
        return new MessageUseCase(messageMessengerPort);
    }
}
