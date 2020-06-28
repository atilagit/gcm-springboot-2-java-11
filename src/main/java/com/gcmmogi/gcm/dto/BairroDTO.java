package com.gcmmogi.gcm.dto;

import java.io.Serializable;

public class BairroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer quantidade;
	private Double percentual;
	
	public BairroDTO() {
	}

	public BairroDTO(String nome, Integer quantidade, Double percentual) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.percentual = percentual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}
}
