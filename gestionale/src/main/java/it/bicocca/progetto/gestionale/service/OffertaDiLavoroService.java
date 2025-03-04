package it.bicocca.progetto.gestionale.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;

import java.util.List;

@Service
public class OffertaDiLavoroService {

    @Autowired
    private OffertaDiLavoroRepository offertaDiLavoroRepository;

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
}
