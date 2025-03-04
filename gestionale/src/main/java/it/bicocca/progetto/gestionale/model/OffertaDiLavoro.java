package it.bicocca.progetto.gestionale.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class OffertaDiLavoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String titolo;
    private String descrizione;
    private String localita;
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
    
    // Getter e Setter
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
        this.titolo = titolo;
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
}