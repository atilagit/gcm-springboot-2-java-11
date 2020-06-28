package com.gcmmogi.gcm.dto;

import java.io.Serializable;

public class BairroTopDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Long quantidadeDeBO;
	private Double percentual;
	
	public BairroTopDTO() {
	}

	public BairroTopDTO(Long id, String nome, Long quantidadeDeBO, Double percentual) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidadeDeBO = quantidadeDeBO;
		this.percentual = percentual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQuantidadeDeBO() {
		return quantidadeDeBO;
	}

	public void setQuantidadeDeBO(Long quantidadeDeBO) {
		this.quantidadeDeBO = quantidadeDeBO;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}
}
