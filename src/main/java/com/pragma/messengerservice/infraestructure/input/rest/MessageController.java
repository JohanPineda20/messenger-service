package com.pragma.messengerservice.infraestructure.input.rest;

import com.pragma.messengerservice.application.dto.MessageRequest;
import com.pragma.messengerservice.application.handler.IMessageHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Messenger Controller")
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final IMessageHandler messageHandler;

    @Operation(summary = "Send sms to customers' cellphones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "sms sent", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request: wrong input data", content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Exception"))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Exception"))),
            @ApiResponse(responseCode = "500", description = "Twilio Error", content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Exception"))),
    })
    @SecurityRequirement(name = "jwt")
    @PostMapping
    @PreAuthorize("hasAnyAuthority({'EMPLOYEE','CUSTOMER'})")
    public ResponseEntity<Void> sendMessage(@Valid @RequestBody MessageRequest messageRequest){
        messageHandler.sendMessage(messageRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
