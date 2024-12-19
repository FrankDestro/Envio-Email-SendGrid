package com.dev.send_grid.services;

import com.dev.send_grid.models.dto.EmailDTO;
import com.dev.send_grid.services.exceptions.EmailException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

@RequiredArgsConstructor
public class SendGridEmailService implements EmailService {

    private Logger LOG = LoggerFactory.getLogger(SendGridEmailService.class);

    private final SendGrid sendGrid;

    public void sendEmail(EmailDTO dto) {
        Email from = new Email(dto.getFromEmail(), dto.getFromName());
        Email to = new Email(dto.getTo());
        Content content = new Content(dto.getContentType(), dto.getBody());
        Mail mail = new Mail(from, dto.getSubject(), to, content);

        try {
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            LOG.info("sending email to " + dto.getTo());
            Response response = sendGrid.api(request);
            if (response.getStatusCode() >= 400 && response.getStatusCode() <= 500) {
                LOG.error("Error sending emai: " + response.getBody());
                throw new EmailException(response.getBody());
            }
            LOG.info("Email sent! Status = " + response.getStatusCode());
        } catch (IOException e) {
            throw new EmailException(e.getMessage());
        }
    }

}
