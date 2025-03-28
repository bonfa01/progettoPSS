package it.bicocca.progetto.gestionale.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Azienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descrizione;

	@OneToMany(mappedBy = "azienda", cascade = CascadeType.ALL)
	private List<OffertaDiLavoro> offerteDiLavoro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<OffertaDiLavoro> getOfferteDiLavoro() {
		return offerteDiLavoro;
	}

	public void setOfferteDiLavoro(List<OffertaDiLavoro> offerteDiLavoro) {
		this.offerteDiLavoro = offerteDiLavoro;
	}
}
