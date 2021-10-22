package com.example.security.couponservice.cutomlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Profile("customlogin")
public class LoginController {

    @Autowired
    private LoginSecurityService loginSecurityService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/authenticate")
    public String validateLogin(String userName, String password) {
        boolean login = loginSecurityService.login(userName, password);
        if (login) {
            return "index";
        }
        return "login";
    }
}
