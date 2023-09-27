package com.sportify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "equipes_eventos")
public class EquipeEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idEquipe;
    private Long idEvento;

    private Date dataInicio;
    private Date dataFim;

	public Long getEquipeId() {
		return idEquipe;
	}

	public void setEquipeId(Long idEquipe) {
		this.idEquipe = idEquipe;
	}

	public Long getEventoId() {
		return idEvento;
	}

	public void setEventoId(Long idEvento) {
		this.idEvento = idEvento;
	}

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
