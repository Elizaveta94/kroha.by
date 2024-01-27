package com.kroha.web;

import com.kroha.domain.ApplicationDto;
import com.kroha.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationController {
    private final EmailService emailService;

    @Value("${app.recipientEmail}")
    private String recipientEmail;

    @Autowired
    public ApplicationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/order")
    public String showForm(Model model) {
        model.addAttribute("applicationForm", new ApplicationDto());
        return "order";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("applicationForm") ApplicationDto applicationForm) {
        sendEmail(applicationForm);
        return "confirmation";
    }

    private void sendEmail(ApplicationDto applicationForm) {
        String subject = "Новая заявка";
        String text = "Имя: " + applicationForm.getName() + "\nТелефон: " + applicationForm.getPhoneNumber()
                + "\nДополнительная информация: " + applicationForm.getAdditionalInfo();

        emailService.sendEmail(recipientEmail, subject, text, applicationForm);
    }
}
