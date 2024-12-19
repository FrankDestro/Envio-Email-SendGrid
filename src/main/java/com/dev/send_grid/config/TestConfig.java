package com.dev.send_grid.config;

import com.dev.send_grid.services.EmailService;
import com.dev.send_grid.services.MockEmailService;
import com.dev.send_grid.services.SendGridEmailService;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }

}
