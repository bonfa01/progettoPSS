package it.bicocca.progetto.gestionale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.bicocca.progetto.gestionale.model.Candidatura;
import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.repository.CandidaturaRepository;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;
import it.bicocca.progetto.gestionale.service.OffertaDiLavoroService;

@Controller
@RequestMapping("/azienda")
public class OffertaDiLavoroController {

	@Autowired
	private OffertaDiLavoroService offertaDiLavoroService;

	@Autowired
	private CandidaturaRepository candidaturaRepository;
	@Autowired
	private OffertaDiLavoroRepository offertaDiLavoroRepository;

	@GetMapping("/offerte")
	public String visualizzaOfferte(Model model) {
		List<OffertaDiLavoro> offerte = offertaDiLavoroRepository.findAll();
		Map<Long, List<Candidatura>> candidaturePerOfferta = new HashMap<>();
		
		for (OffertaDiLavoro offerta : offerte) {
			List<Candidatura> candidature = candidaturaRepository.findByOfferta(offerta);
			candidaturePerOfferta.put(offerta.getId(), candidature);
		}

		model.addAttribute("offerte", offerte);
		model.addAttribute("candidaturePerOfferta", candidaturePerOfferta);

		return "offerte";
	}

	@GetMapping("/creaOfferta")
	public String creaOffertaForm(Model model) {
		model.addAttribute("offerta", new OffertaDiLavoro());
		return "creaOfferta";
	}

	@PostMapping("/creaOfferta")
	public String creaOfferta(@ModelAttribute OffertaDiLavoro offerta) {
		offertaDiLavoroService.pubblicaOfferta(offerta);
		return "redirect:/azienda/offerte";
	}

	@PostMapping("/eliminaOfferta/{id}")
	public String eliminaOfferta(@PathVariable Long id) {
		offertaDiLavoroService.eliminaOfferta(id);
		return "redirect:/azienda/offerte";
	}

	@GetMapping("/calendario")
	public String visualizzaCalendario() {
		return "calendario";
	}

}
