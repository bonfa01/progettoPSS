package it.bicocca.progetto.gestionale.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidature")
public class Candidatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "offerta_id", nullable = false)
	private OffertaDiLavoro offerta;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false)
	private String email;

	public Candidatura() {
	}

	public Candidatura(OffertaDiLavoro offerta, String nome, String email, String cognome) {
		this.offerta = offerta;
		this.nome = nome;
		this.email = email;
		this.cognome = cognome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffertaDiLavoro getOfferta() {
		return offerta;
	}

	public void setOfferta(OffertaDiLavoro offerta) {
		this.offerta = offerta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}