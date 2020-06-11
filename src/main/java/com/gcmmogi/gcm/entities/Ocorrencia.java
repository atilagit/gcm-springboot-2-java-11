package com.gcmmogi.gcm.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_ocorrencia")
public class  Ocorrencia implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoDaOcorrencia;
	private String naturezaDaOcorrencia;

	@JsonIgnore
	@ManyToMany(mappedBy = "ocorrencias")
	private Set<BoletimOcorrencia> boletins = new HashSet<>();
	
	public Ocorrencia() {
	}

	public Ocorrencia(Long id, String codigoDaOcorrencia, String naturezaDaOcorrencia) {
		super();
		this.id = id;
		this.codigoDaOcorrencia = codigoDaOcorrencia;
		this.naturezaDaOcorrencia = naturezaDaOcorrencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoDaOcorrencia() {
		return codigoDaOcorrencia;
	}

	public void setCodigoDaOcorrencia(String codigoDaOcorrencia) {
		this.codigoDaOcorrencia = codigoDaOcorrencia;
	}

	public String getNaturezaDaOcorrencia() {
		return naturezaDaOcorrencia;
	}

	public void setNaturezaDaOcorrencia(String naturezaDaOcorrencia) {
		this.naturezaDaOcorrencia = naturezaDaOcorrencia;
	}

	public Set<BoletimOcorrencia> getBoletins() {
		return boletins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDaOcorrencia == null) ? 0 : codigoDaOcorrencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ocorrencia other = (Ocorrencia) obj;
		if (codigoDaOcorrencia == null) {
			if (other.codigoDaOcorrencia != null)
				return false;
		} else if (!codigoDaOcorrencia.equals(other.codigoDaOcorrencia))
			return false;
		return true;
	}
}
