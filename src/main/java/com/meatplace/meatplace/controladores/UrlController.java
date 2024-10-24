package com.meatplace.meatplace.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UrlController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/reserva")
    public String reserva(Model model) {
            model.addAttribute("formulario", 0);
        return "reserva";
    }

    
    
    
}
