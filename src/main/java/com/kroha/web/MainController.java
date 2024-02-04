package com.kroha.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class MainController {
    // сюда надо добавить продукт сервис

    @GetMapping("/mainPage")
    public String mainPage(Principal principal, Model model) {
        return "mainPage";
    }

    @GetMapping("/aboutMe")
    public String aboutMe(Principal principal, Model model) {
        return "aboutMe";
    }
    @GetMapping("/portfolio")
    public String portfolio(Principal principal, Model model) {
        // а тут надо с помощью продукт сервиса взять лист продуктов
        // и положить этот лист в model как в веселе, model.addAttribute("products", products)
        return "portfolio";
    }
    @GetMapping("/stages")
    public String stage(Principal principal, Model model) {
        return "stagesOfWork";
    }
}
