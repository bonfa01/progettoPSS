package it.bicocca.progetto.gestionale.controller;


import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OffertePubblicheController {

    @Autowired
    private OffertaDiLavoroRepository offertaDiLavoroRepository;

    
    @GetMapping("/visualizzaOfferte")
    public String visualizzaOfferte(Model model) {
        List<OffertaDiLavoro> offerte = offertaDiLavoroRepository.findAll();
        model.addAttribute("offerte", offerte);
        return "visualizzaOfferte"; 
    }
}