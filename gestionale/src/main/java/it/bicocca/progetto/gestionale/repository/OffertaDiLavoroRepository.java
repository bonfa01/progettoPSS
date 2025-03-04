package it.bicocca.progetto.gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bicocca.progetto.gestionale.model.OffertaDiLavoro;

import java.util.List;

public interface OffertaDiLavoroRepository extends JpaRepository<OffertaDiLavoro, Long> {
    List<OffertaDiLavoro> findByAttivaTrue();
}
