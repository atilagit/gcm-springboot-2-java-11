package com.gcmmogi.gcm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rg")
public class RG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroDoRG;
	private String orgaoExpedidor;
	private String estado;

	// private Envolvido envolvido;

	public RG() {
	}

	public RG(Long id, String numeroDoRG, String orgaoExpedidor, String estado) {
		super();
		this.id = id;
		this.numeroDoRG = numeroDoRG;
		this.orgaoExpedidor = orgaoExpedidor;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroDoRG() {
		return numeroDoRG;
	}

	public void setNumeroDoRG(String numeroDoRG) {
		this.numeroDoRG = numeroDoRG;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDoRG == null) ? 0 : numeroDoRG.hashCode());
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
		RG other = (RG) obj;
		if (numeroDoRG == null) {
			if (other.numeroDoRG != null)
				return false;
		} else if (!numeroDoRG.equals(other.numeroDoRG))
			return false;
		return true;
	}
}
