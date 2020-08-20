package com.gcmmogi.gcm.dto;

import java.io.Serializable;

public class BoletimDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String oficial;
	private String ocorrencias;
	private String bairro;
	private String envolvidos;

	public BoletimDTO() {
	}

	public BoletimDTO(Long id, String oficial, String ocorrencias, String bairro, String envolvidos) {
		super();
		this.id = id;
		this.oficial = oficial;
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

	public String getOficial() {
		return oficial;
	}

	public void setOficial(String oficial) {
		this.oficial = oficial;
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
