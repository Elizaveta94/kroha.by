package com.kroha.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/ropotLogin")
    public String login() {
        return "login";
    }

}
