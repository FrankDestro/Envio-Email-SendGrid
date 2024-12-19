package com.dev.send_grid.services;

import com.dev.send_grid.models.dto.EmailDTO;

public interface EmailService {
    void sendEmail(EmailDTO dto);
}
