package com.kroha.service;

import com.kroha.domain.ApplicationDto;

public interface EmailService {
    void sendEmail(String recipientEmail, String subject, String text, ApplicationDto applicationDto);
}

