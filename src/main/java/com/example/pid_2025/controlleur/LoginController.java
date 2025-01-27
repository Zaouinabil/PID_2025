package com.example.pid_2025.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(
            @RequestParam(required=false) final Boolean loginRequired,
            @RequestParam(required=false) final Boolean loginError,
            @RequestParam(required=false) final Boolean logoutSuccess,
            final Model model) {
        if (loginRequired == Boolean.TRUE) {
            model.addAttribute("errorMessage", "vous devez vous connecter pour avoir acces.");
        }
        if (loginError == Boolean.TRUE) {
            model.addAttribute("errorMessage", "Echec de la connexion!");
        }
        if (logoutSuccess == Boolean.TRUE) {
            model.addAttribute("succesMessage", "Vous etes deconnecté avec succés.");
        }
        return "autentication/login";
    }

}



