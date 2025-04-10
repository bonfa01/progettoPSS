package it.bicocca.progetto.gestionale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.bicocca.progetto.gestionale.model.Candidatura;
import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.repository.CandidaturaRepository;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OffertaDiLavoroService {

    @Autowired
    private OffertaDiLavoroRepository offertaDiLavoroRepository;
    
    @Autowired
    private CandidaturaRepository candidaturaRepository;

    public List<OffertaDiLavoro> getOfferte() {
        return offertaDiLavoroRepository.findAll();
    }

    public OffertaDiLavoro pubblicaOfferta(OffertaDiLavoro offerta) {
        offerta.setAttiva(true);
        return offertaDiLavoroRepository.save(offerta);
    }

    public void eliminaOfferta(Long id) {
        offertaDiLavoroRepository.deleteById(id);
    }

    public List<OffertaDiLavoro> getOfferteAttive() {
        return offertaDiLavoroRepository.findByAttivaTrue();
    }

    public Map<Long, List<Candidatura>> getCandidaturePerOfferta(List<OffertaDiLavoro> offerte) {
        Map<Long, List<Candidatura>> candidaturePerOfferta = new HashMap<>();
        for (OffertaDiLavoro offerta : offerte) {
            List<Candidatura> candidature = candidaturaRepository.findByOfferta(offerta);
            candidaturePerOfferta.put(offerta.getId(), candidature);
        }
        return candidaturePerOfferta;
    }
}
