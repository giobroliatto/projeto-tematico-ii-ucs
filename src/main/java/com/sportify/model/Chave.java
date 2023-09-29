package com.sportify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chaves")
public class Chave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idEvento;
    
    private Long idPartida1Oitavas;
    private Long idPartida2Oitavas;
    private Long idPartida3Oitavas;
    private Long idPartida4Oitavas;
    private Long idPartida5Oitavas;
    private Long idPartida6Oitavas;
    private Long idPartida7Oitavas;
    private Long idPartida8Oitavas;
    
    private Long idPartida1Quartas;
    private Long idPartida2Quartas;
    private Long idPartida3Quartas;
    private Long idPartida4Quartas;
    
    private Long idPartida1Semi;
    private Long idPartida2Semi;
    
    private Long idPartidaFinal;

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

    public Long getIdPartida1Oitavas() {
        return idPartida1Oitavas;
    }

    public void setIdPartida1Oitavas(Long idPartida1Oitavas) {
        this.idPartida1Oitavas = idPartida1Oitavas;
    }

    public Long getIdPartida2Oitavas() {
        return idPartida2Oitavas;
    }

    public void setIdPartida2Oitavas(Long idPartida2Oitavas) {
        this.idPartida2Oitavas = idPartida2Oitavas;
    }

    public Long getIdPartida3Oitavas() {
        return idPartida3Oitavas;
    }

    public void setIdPartida3Oitavas(Long idPartida3Oitavas) {
        this.idPartida3Oitavas = idPartida3Oitavas;
    }

    public Long getIdPartida4Oitavas() {
        return idPartida4Oitavas;
    }

    public void setIdPartida4Oitavas(Long idPartida4Oitavas) {
        this.idPartida4Oitavas = idPartida4Oitavas;
    }

    public Long getIdPartida5Oitavas() {
        return idPartida5Oitavas;
    }

    public void setIdPartida5Oitavas(Long idPartida5Oitavas) {
        this.idPartida5Oitavas = idPartida5Oitavas;
    }

    public Long getIdPartida6Oitavas() {
        return idPartida6Oitavas;
    }

    public void setIdPartida6Oitavas(Long idPartida6Oitavas) {
        this.idPartida6Oitavas = idPartida6Oitavas;
    }

    public Long getIdPartida7Oitavas() {
        return idPartida7Oitavas;
    }

    public void setIdPartida7Oitavas(Long idPartida7Oitavas) {
        this.idPartida7Oitavas = idPartida7Oitavas;
    }

    public Long getIdPartida8Oitavas() {
        return idPartida8Oitavas;
    }

    public void setIdPartida8Oitavas(Long idPartida8Oitavas) {
        this.idPartida8Oitavas = idPartida8Oitavas;
    }

    public Long getIdPartida1Quartas() {
        return idPartida1Quartas;
    }

    public void setIdPartida1Quartas(Long idPartida1Quartas) {
        this.idPartida1Quartas = idPartida1Quartas;
    }

    public Long getIdPartida2Quartas() {
        return idPartida2Quartas;
    }

    public void setIdPartida2Quartas(Long idPartida2Quartas) {
        this.idPartida2Quartas = idPartida2Quartas;
    }

    public Long getIdPartida3Quartas() {
        return idPartida3Quartas;
    }

    public void setIdPartida3Quartas(Long idPartida3Quartas) {
        this.idPartida3Quartas = idPartida3Quartas;
    }

    public Long getIdPartida4Quartas() {
        return idPartida4Quartas;
    }

    public void setIdPartida4Quartas(Long idPartida4Quartas) {
        this.idPartida4Quartas = idPartida4Quartas;
    }

    public Long getIdPartida1Semi() {
        return idPartida1Semi;
    }

    public void setIdPartida1Semi(Long idPartida1Semi) {
        this.idPartida1Semi = idPartida1Semi;
    }

    public Long getIdPartida2Semi() {
        return idPartida2Semi;
    }

    public void setIdPartida2Semi(Long idPartida2Semi) {
        this.idPartida2Semi = idPartida2Semi;
    }

    public Long getIdPartidaFinal() {
        return idPartidaFinal;
    }

    public void setIdPartidaFinal(Long idPartidaFinal) {
        this.idPartidaFinal = idPartidaFinal;
    }
}

