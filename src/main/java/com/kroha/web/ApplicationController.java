package com.kroha.web;

import com.kroha.domain.ApplicationDto;
import com.kroha.domain.ProductDto;
import com.kroha.service.EmailService;
import com.kroha.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ApplicationController {
    private final EmailService emailService;
    private final ProductService productService;
    @Value("${app.recipientEmail}")
    private String recipientEmail;

    @GetMapping("/order/{id}")
    public String showForm(Model model, @PathVariable("id") Long id) {
        ProductDto productDto = productService.getById(id);
        model.addAttribute("applicationForm", new ApplicationDto());
        model.addAttribute("additionalInfo", "%s. %s. Цена: %s BYN".formatted(productDto.getTitle(), productDto.getDescription(), productDto.getCost()));
        return "order";
    }

    @GetMapping("/order")
    public String showForm(Model model) {
        model.addAttribute("applicationForm", new ApplicationDto());
        model.addAttribute("additionalInfo", null);
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
