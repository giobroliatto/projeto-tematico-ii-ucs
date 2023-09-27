package com.sportify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resultados")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private int placarEquipeA;
    private int placarEquipeB;
    private int idEquipeVencedora;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public int getIdEquipeVencedora() {
        return idEquipeVencedora;
    }
    public void setIdEquipeVencedora(int idEquipeVencedora) {
        this.idEquipeVencedora = idEquipeVencedora;
    }
}
