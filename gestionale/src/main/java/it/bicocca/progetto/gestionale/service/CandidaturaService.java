package it.bicocca.progetto.gestionale.service;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.bicocca.progetto.gestionale.model.Candidatura;
import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;
import it.bicocca.progetto.gestionale.model.User;
import it.bicocca.progetto.gestionale.repository.CandidaturaRepository;
import it.bicocca.progetto.gestionale.repository.OffertaDiLavoroRepository;
import it.bicocca.progetto.gestionale.repository.UserRepository;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private OffertaDiLavoroRepository offertaDiLavoroRepository;
    
    @Autowired
    private UserRepository userRepository;

    public String inviaCandidatura(Long offertaId, Principal principal, RedirectAttributes redirectAttributes) {
        String email = principal.getName();
        User user = userRepository.findByEmail(email.toLowerCase().trim());
        
        if (user == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Utente non trovato.");
            return "redirect:/visualizzaOfferte";
        }

        Optional<OffertaDiLavoro> offertaOpt = offertaDiLavoroRepository.findById(offertaId);
        
        if (offertaOpt.isPresent()) {
            Candidatura candidatura = new Candidatura(offertaOpt.get(), 
            		user.getNome(), 
            		user.getEmail(), 
            		user.getCognome());
            candidaturaRepository.save(candidatura);
            redirectAttributes.addFlashAttribute("successMessage", "Candidatura inviata con successo!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Offerta non trovata.");
        }

        return "redirect:/visualizzaOfferte";
    }
}
