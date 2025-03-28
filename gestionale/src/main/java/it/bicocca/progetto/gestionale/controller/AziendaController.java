package it.bicocca.progetto.gestionale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/azienda")
public class AziendaController {

	@GetMapping("/loginAzienda")
	public String adminLogin() {
		return "loginAzienda";
	}

	
}
