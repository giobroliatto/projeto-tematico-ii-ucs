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

    private Long equipeid;
    private Long eventoid;

    private Date dataInicio;
    private Date dataFim;

	public Long getEquipeId() {
		return equipeid;
	}

	public void setEquipeId(Long equipeid) {
		this.equipeid = equipeid;
	}

	public Long getEventoId() {
		return eventoid;
	}

	public void setEventoId(Long eventoid) {
		this.eventoid = eventoid;
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
