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
    
    private int idResultado;
    private int idEvento;
    private int idEquipeA;
    private int idEquipeB;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getIdResultado() {
        return idResultado;
    }
    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public int getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdEquipeA() {
        return idEquipeA;
    }
    public void setIdEquipeA(int idEquipeA) {
        this.idEquipeA = idEquipeA;
    }

    public int getIdEquipeB() {
        return idEquipeB;
    }
    public void setIdEquipeB(int idEquipeB) {
        this.idEquipeB = idEquipeB;
    }
}
