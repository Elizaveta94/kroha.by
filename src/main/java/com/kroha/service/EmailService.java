package com.kroha.service;

public interface EmailService {
    void sendEmail(String recipientEmail, String subject, String text);
}

