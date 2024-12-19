package com.dev.send_grid.config;

import com.dev.send_grid.services.EmailService;
import com.dev.send_grid.services.SendGridEmailService;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Value("${sendgrid.api-key}")
    private String sendGridApiKey;

    @Bean
    public SendGrid sendGrid() {
        return new SendGrid(sendGridApiKey);
    }

    @Bean
    public EmailService emailService(SendGrid sendGrid) {
        return new SendGridEmailService(sendGrid);
    }

}
