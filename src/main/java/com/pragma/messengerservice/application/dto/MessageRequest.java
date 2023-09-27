package com.pragma.messengerservice.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageRequest {
    @NotBlank(message = "message cannot be empty")
    private String message;

    @NotBlank(message = "cellphone is required")
    @Pattern(regexp = "^\\+?[0-9]{1,12}$", message = "phone is invalid")
    private String cellphone;
}
