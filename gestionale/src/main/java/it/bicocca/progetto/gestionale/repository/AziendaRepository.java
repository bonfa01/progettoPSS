package it.bicocca.progetto.gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.bicocca.progetto.gestionale.model.Azienda;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Long> {
	
}
