package it.bicocca.progetto.gestionale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import it.bicocca.progetto.gestionale.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Visualizza la pagina di registrazione
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";  // Riferimento al template register.html
    }

    // Gestisce la registrazione degli utenti
    @PostMapping("/user/register")
    public String registerUser(@RequestParam String nome,
                               @RequestParam String cognome,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role, 
                               Model model) {
        try {
            userService.registerUser(nome, cognome, email, password, role);
            model.addAttribute("message", "Utente registrato con successo!");
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    // Visualizza la pagina di login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Riferimento al template login.html
    }
}
