package it.bicocca.progetto.gestionale.controller;

import it.bicocca.progetto.gestionale.model.User;
import it.bicocca.progetto.gestionale.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/azienda")
public class AnagraficaController {

	@Autowired
	private AnagraficaService anagraficaService;

	@GetMapping("/anagrafica")
	public String listUsers(Model model) {
		List<User> users = anagraficaService.getAllUsers();
		model.addAttribute("users", users);
		return "anagrafica";
	}
}
