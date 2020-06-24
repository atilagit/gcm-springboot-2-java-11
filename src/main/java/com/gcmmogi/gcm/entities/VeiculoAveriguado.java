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
import com.gcmmogi.gcm.entities.enums.Dano;

@Entity
@Table(name = "tb_veiculoAveriguado")
public class VeiculoAveriguado implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private String modelo;
	private Integer ano;
	private String cor;
	private String codRenavam;
	
	private Integer dano;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "veiculos")
	private Set<BoletimOcorrencia> boletins = new HashSet<>();
	
	public VeiculoAveriguado() {
	}
	
	public VeiculoAveriguado(Long id, String placa, String modelo, Integer ano, String cor, String codRenavam, Dano dano) {
		super();
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.codRenavam = codRenavam;
		setDano(dano);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCodRenavam() {
		return codRenavam;
	}

	public void setCodRenavam(String codRenavam) {
		this.codRenavam = codRenavam;
	}

	public Dano getDano() {
		return Dano.valueOf(dano);
	}

	public void setDano(Dano dano) {
		if(dano != null) {
			this.dano = dano.getCode();
		}
	}
	
	public Set<BoletimOcorrencia> getBoletins() {
		return boletins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((codRenavam == null) ? 0 : codRenavam.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((dano == null) ? 0 : dano.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		VeiculoAveriguado other = (VeiculoAveriguado) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (codRenavam == null) {
			if (other.codRenavam != null)
				return false;
		} else if (!codRenavam.equals(other.codRenavam))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (dano == null) {
			if (other.dano != null)
				return false;
		} else if (!dano.equals(other.dano))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
}
