package com.sportify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idEvento;
    private Long idEquipeA;
    private Long idEquipeB;
    private int placarEquipeA;
    private int placarEquipeB;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdEquipeA() {
        return idEquipeA;
    }
    public void setIdEquipeA(Long idEquipeA) {
        this.idEquipeA = idEquipeA;
    }

    public Long getIdEquipeB() {
        return idEquipeB;
    }
    public void setIdEquipeB(Long idEquipeB) {
        this.idEquipeB = idEquipeB;
    }
    
    public int getPlacarEquipeA() {
        return placarEquipeA;
    }
    public void setPlacarEquipeA(int placarEquipeA) {
        this.placarEquipeA = placarEquipeA;
    }

    public int getPlacarEquipeB() {
        return placarEquipeB;
    }
    public void setPlacarEquipeB(int placarEquipeB) {
        this.placarEquipeB = placarEquipeB;
    }
}
