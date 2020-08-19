package com.gcmmogi.gcm.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeusBoletinsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@JsonProperty("numero")
	private Integer numeroDaOcorrencia;
	
	private String ocorrencias;
	private String bairro;
	private String envolvidos;

	public MeusBoletinsDTO() {
	}

	public MeusBoletinsDTO(Long id, Integer numeroDaOcorrencia, String ocorrencias, String bairro, String envolvidos) {
		super();
		this.id = id;
		this.numeroDaOcorrencia = numeroDaOcorrencia;
		this.ocorrencias = ocorrencias;
		this.bairro = bairro;
		this.envolvidos = envolvidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroDaOcorrencia() {
		return numeroDaOcorrencia;
	}

	public void setNumeroDaOcorrencia(Integer numeroDaOcorrencia) {
		this.numeroDaOcorrencia = numeroDaOcorrencia;
	}

	public String getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(String ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEnvolvidos() {
		return envolvidos;
	}

	public void setEnvolvidos(String envolvidos) {
		this.envolvidos = envolvidos;
	}
}
