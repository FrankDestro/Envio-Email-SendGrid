package com.dev.send_grid.controllers;

import com.dev.send_grid.models.dto.EmailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emails")
public class EmailController {

    @PostMapping(value = "/send")
    public ResponseEntity<Void> send(@RequestBody EmailDTO dto){
        return ResponseEntity.noContent().build();
    }
}
