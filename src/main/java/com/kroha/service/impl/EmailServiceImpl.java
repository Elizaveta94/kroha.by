package com.kroha.service.impl;

import com.kroha.domain.ApplicationDto;
import com.kroha.service.validation.FormValidator;
import org.springframework.mail.SimpleMailMessage;
import com.kroha.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Builder
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    private final FormValidator formValidator;

    @Override
    public void sendEmail(String recipientEmail, String subject, String text, ApplicationDto applicationDto) {
        formValidator.validate(applicationDto);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}

