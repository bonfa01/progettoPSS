package it.bicocca.progetto.gestionale.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.bicocca.progetto.gestionale.model.User;
import it.bicocca.progetto.gestionale.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
 
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";  
    }
 
    @PostMapping("/user/register")
    public String registerUser(@RequestParam String nome,
                               @RequestParam String cognome,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String numeroTelefono,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascita,
                               @RequestParam String sesso,
                               @RequestParam String residenza,
                               @RequestParam String role,
                               Model model) {
        try {
            userService.registerUser(nome, cognome, email, password, numeroTelefono, dataNascita, sesso, residenza, role);
            model.addAttribute("message", "Utente registrato con successo!");
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  
    }
    
    @GetMapping("/areaPersonale")
    public String modificaUtente(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        return "areaPersonale";
    }

    @PostMapping("/areaPersonale")
    public String salvaModifiche(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute User userModificato) {
        User userEsistente = userService.findByEmail(userDetails.getUsername());

        userEsistente.setNome(userModificato.getNome());
        userEsistente.setCognome(userModificato.getCognome());
        userEsistente.setEmail(userModificato.getEmail());
        userEsistente.setNumeroTelefono(userModificato.getNumeroTelefono());
        userEsistente.setResidenza(userModificato.getResidenza());

        userService.aggiornaUtente(userEsistente);

        return "redirect:/areaPersonale";
    }

  
}
