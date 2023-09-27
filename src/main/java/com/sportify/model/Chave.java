package com.sportify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "chaves")
public class Chave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int idEvento;
    
    private List<Long> idPartidasOitavas; 
    private List<Long> idPartidasQuartas;
    private List<Long> idPartidasSemi;
    
    private Long idPartidaFinal;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public List<Long> getIdPartidasOitavas() {
        return idPartidasOitavas;
    }
    public void setIdPartidasOitavas(List<Long> idPartidasOitavas) {
        this.idPartidasOitavas = idPartidasOitavas;
    }

    public List<Long> getIdPartidasQuartas() {
        return idPartidasQuartas;
    }
    public void setIdPartidasQuartas(List<Long> idPartidasQuartas) {
        this.idPartidasQuartas = idPartidasQuartas;
    }

    public List<Long> getIdPartidasSemi() {
        return idPartidasSemi;
    }
    public void setIdPartidasSemi(List<Long> idPartidasSemi) {
        this.idPartidasSemi = idPartidasSemi;
    }

    public Long getIdPartidaFinal() {
        return idPartidaFinal;
    }
    public void setIdPartidaFinal(Long idPartidaFinal) {
        this.idPartidaFinal = idPartidaFinal;
    }
}

