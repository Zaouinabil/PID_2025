package com.example.pid_2025.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "layouts/home"; // Cette vue doit correspondre à un fichier home.html dans le dossier templates
    }
}
