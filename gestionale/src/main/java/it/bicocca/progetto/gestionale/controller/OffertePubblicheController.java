package it.bicocca.progetto.gestionale.controller;

import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.model.User;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;
import it.bicocca.progetto.gestionale.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OffertePubblicheController {

	@Autowired
	private OffertaDiLavoroRepository offertaDiLavoroRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/visualizzaOfferte")
	public String visualizzaOfferte(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		List<OffertaDiLavoro> offerte = offertaDiLavoroRepository.findAll();
		model.addAttribute("offerte", offerte);
		
		if (userDetails != null) {
	        User user = userRepository.findByEmail(userDetails.getUsername());
	        model.addAttribute("user", user); 
	    }
		
		return "visualizzaOfferte";
	}
}