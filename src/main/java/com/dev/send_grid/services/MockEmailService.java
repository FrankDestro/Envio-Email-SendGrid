package com.dev.send_grid.services;

import com.dev.send_grid.models.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class MockEmailService implements EmailService {

    private Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    public void sendEmail(EmailDTO dto) {
        LOG.info("sending email to " + dto.getTo());
        LOG.info("Email sent! Status");
    }
}
