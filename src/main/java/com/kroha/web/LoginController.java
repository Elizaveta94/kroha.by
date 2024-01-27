package com.kroha.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/ropotLogin")
    public String login() {
        return "login";
    }

    @PostMapping("/ropotLogin")
    public String loginPost() {
        return "login";
    }
}
