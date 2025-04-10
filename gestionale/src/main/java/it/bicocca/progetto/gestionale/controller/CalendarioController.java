package it.bicocca.progetto.gestionale.controller;

import org.springframework.web.bind.annotation.*;

import it.bicocca.progetto.gestionale.service.CalendarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/azienda/calendario")
public class CalendarioController {

	private final CalendarioService calendarioService;

	public CalendarioController(CalendarioService calendarioService) {
		this.calendarioService = calendarioService;
	}

	@GetMapping("/eventi")
	public List<Map<String, Object>> getEventi() {
		return calendarioService.getEventi();
	}
}
