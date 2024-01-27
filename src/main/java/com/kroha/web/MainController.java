package com.kroha.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/mainPage")
    public String mainPage(Principal principal, Model model) {
        String name = principal.getName();
        return "mainPage";
    }

    @GetMapping("/aboutMe")
    public String aboutMe(Principal principal, Model model) {
        return "aboutMe";
    }
    @GetMapping("/portfolio")
    public String portfolio(Principal principal, Model model) {
        return "portfolio";
    }
    @GetMapping("/stages")
    public String stage(Principal principal, Model model) {
        return "stagesOfWork";
    }
}
