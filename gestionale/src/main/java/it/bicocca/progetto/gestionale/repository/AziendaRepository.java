package it.bicocca.progetto.gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bicocca.progetto.gestionale.model.Azienda;

public interface AziendaRepository extends JpaRepository<Azienda, Long> {
}
