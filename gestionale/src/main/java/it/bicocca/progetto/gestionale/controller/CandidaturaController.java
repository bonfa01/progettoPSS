package it.bicocca.progetto.gestionale.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.bicocca.progetto.gestionale.model.Candidatura;
import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.repository.CandidaturaRepository;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;

@Controller
@RequestMapping("/candidature")
public class CandidaturaController {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private OffertaDiLavoroRepository offertaDiLavoroRepository;

    @PostMapping("/invia/{offertaId}")
    public String inviaCandidatura(@PathVariable Long offertaId,
                                   @RequestParam String nome,
                                   @RequestParam String email,
                                   @RequestParam String cognome,
                                   RedirectAttributes redirectAttributes) {

        Optional<OffertaDiLavoro> offertaOpt = offertaDiLavoroRepository.findById(offertaId);
        if (offertaOpt.isPresent()) {
            Candidatura candidatura = new Candidatura(offertaOpt.get(), nome, email, cognome);
            candidaturaRepository.save(candidatura);

            redirectAttributes.addFlashAttribute("successMessage", "Candidatura inviata con successo!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Offerta non trovata.");
        }

        return "redirect:/visualizzaOfferte";
    }
}