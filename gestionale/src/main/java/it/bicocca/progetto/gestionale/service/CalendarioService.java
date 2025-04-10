package it.bicocca.progetto.gestionale.service;

import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class CalendarioService {

    private final OffertaDiLavoroRepository offertaDiLavoroRepository;

    public CalendarioService(OffertaDiLavoroRepository offertaDiLavoroRepository) {
        this.offertaDiLavoroRepository = offertaDiLavoroRepository;
    }

    public List<Map<String, Object>> getEventi() {
        List<OffertaDiLavoro> offerte = offertaDiLavoroRepository.findAll();
        return offerte.stream().map(offerta -> {
            Map<String, Object> evento = new HashMap<>();
            evento.put("title", offerta.getTitolo());
            evento.put("start", offerta.getDataInizio());
            evento.put("end", 	offerta.getDataFine());
            return evento;
        }).collect(Collectors.toList());
    }
}
