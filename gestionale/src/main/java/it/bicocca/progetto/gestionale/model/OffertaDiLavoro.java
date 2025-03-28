package it.bicocca.progetto.gestionale.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class OffertaDiLavoro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titolo;
	
	@Column(length = 1500)
	private String descrizione;
	private String localita;
	private String compenso;
	private String requisiti;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataInizio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataFine;
	private boolean attiva;

	@ManyToOne
	@JoinColumn(name = "azienda_id")
	private Azienda azienda;

	@OneToMany(mappedBy = "offerta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Candidatura> candidature = new ArrayList<>();

	public List<Candidatura> getCandidature() {
		return candidature;
	}

	public void setCandidature(List<Candidatura> candidature) {
		this.candidature = candidature;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo.toUpperCase();
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public boolean isAttiva() {
		return attiva;
	}

	public void setAttiva(boolean attiva) {
		this.attiva = attiva;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public String getCompenso() {
		return compenso;
	}

	public void setCompenso(String compenso) {
		this.compenso = compenso;
	}

	public String getRequisiti() {
		return requisiti;
	}

	public void setRequisiti(String requisiti) {
		this.requisiti = requisiti;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}
}