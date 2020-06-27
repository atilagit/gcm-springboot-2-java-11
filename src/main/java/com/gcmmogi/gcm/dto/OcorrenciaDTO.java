package com.gcmmogi.gcm.dto;

import java.io.Serializable;

public class OcorrenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigoDaOcorrencia;
	private String naturezaDaOcorrencia;
	private Integer quantidade;
	private Double percentual;
	
	public OcorrenciaDTO() {
	}
	
	public OcorrenciaDTO(String codigoDaOcorrencia, String naturezaDaOcorrencia, Integer quantidade, Double percentual) {
		this.codigoDaOcorrencia = codigoDaOcorrencia;
		this.naturezaDaOcorrencia = naturezaDaOcorrencia;
		this.quantidade = quantidade;
		this.percentual = percentual;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void aumentaQuantidade() {
		quantidade++;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDaOcorrencia == null) ? 0 : codigoDaOcorrencia.hashCode());
		result = prime * result + ((naturezaDaOcorrencia == null) ? 0 : naturezaDaOcorrencia.hashCode());
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
		OcorrenciaDTO other = (OcorrenciaDTO) obj;
		if (codigoDaOcorrencia == null) {
			if (other.codigoDaOcorrencia != null)
				return false;
		} else if (!codigoDaOcorrencia.equals(other.codigoDaOcorrencia))
			return false;
		if (naturezaDaOcorrencia == null) {
			if (other.naturezaDaOcorrencia != null)
				return false;
		} else if (!naturezaDaOcorrencia.equals(other.naturezaDaOcorrencia))
			return false;
		return true;
	}
}
