package com.dev.send_grid.controllers;

import com.dev.send_grid.models.dto.EmailDTO;
import com.dev.send_grid.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/emails")
public class EmailController {

    private final EmailService emailService;

    @PostMapping(value = "/send")
    public ResponseEntity<Void> send(@RequestBody EmailDTO dto) throws IOException {
        emailService.sendEmail(dto);
        return ResponseEntity.noContent().build();
    }
}
