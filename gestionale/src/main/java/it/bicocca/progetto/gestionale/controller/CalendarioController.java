package it.bicocca.progetto.gestionale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/azienda/calendario")
public class CalendarioController {

	@Autowired
	private OffertaDiLavoroRepository offertaDiLavoroRepository;

	@GetMapping("/eventi")
	public List<Map<String, Object>> getEventi() {
		List<OffertaDiLavoro> offerte = offertaDiLavoroRepository.findAll();
		return offerte.stream().map(offerta -> {
			Map<String, Object> evento = new HashMap<>();
			evento.put("title", offerta.getTitolo());
			evento.put("start", offerta.getDataInizio() != null ? offerta.getDataInizio().toString() : "");
			evento.put("end", offerta.getDataFine() != null ? offerta.getDataFine().toString() : "");
			return evento;
		}).collect(Collectors.toList());
	}
}
