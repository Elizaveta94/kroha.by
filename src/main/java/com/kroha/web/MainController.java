package com.kroha.web;

import com.kroha.domain.ProductDto;
import com.kroha.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;

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
        model.addAttribute("products", productService.getAll());
        model.addAttribute("authorised", principal != null);
        return "portfolio";
    }

    @GetMapping("/stages")
    public String stage(Principal principal, Model model) {
        return "stagesOfWork";
    }
}
