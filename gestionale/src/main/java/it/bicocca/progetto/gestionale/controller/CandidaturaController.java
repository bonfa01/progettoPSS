package it.bicocca.progetto.gestionale.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.bicocca.progetto.gestionale.service.CandidaturaService;

@Controller
@RequestMapping("/candidature")
public class CandidaturaController {

	@Autowired
	private CandidaturaService candidaturaService;

	@PostMapping("/invia/{offertaId}")
	public String inviaCandidatura(@PathVariable Long offertaId, Principal principal, RedirectAttributes redirectAttributes) {
		return candidaturaService.inviaCandidatura(offertaId, principal, redirectAttributes);
	}
}
