package com.gcmmogi.gcm.dto;

import java.io.Serializable;
import java.time.Instant;

public class EnvolvidoNovoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	//Dados do envolvido
	private Integer condicaoDaParte;
	private Boolean conduzido;
	private String nome;
	private Instant dataNascimento;
	private String pai;
	private String mae;
	private String nacionalidade;
	private String naturalidadeCidade;
	private String naturalidadeEstado;
	private String telefone;
	private String localDeTrabalho;
	private String versaoDoEnvolvido;
	
	//Dados do endereço do envolvido
	private String residencia;
	private int numero;
	private String bairro;
	private String cidade;
	private String estadoEnd;
	private String complemento;
	
	//Dados do RG do envolvido
	private String numeroDoRG;
	private String orgaoExpedidor;
	private String estadoRG;
	
	public EnvolvidoNovoDTO() {
	}

	public Integer getCondicaoDaParte() {
		return condicaoDaParte;
	}

	public void setCondicaoDaParte(Integer condicaoDaParte) {
		this.condicaoDaParte = condicaoDaParte;
	}

	public Boolean getConduzido() {
		return conduzido;
	}

	public void setConduzido(Boolean conduzido) {
		this.conduzido = conduzido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidadeCidade() {
		return naturalidadeCidade;
	}

	public void setNaturalidadeCidade(String naturalidadeCidade) {
		this.naturalidadeCidade = naturalidadeCidade;
	}

	public String getNaturalidadeEstado() {
		return naturalidadeEstado;
	}

	public void setNaturalidadeEstado(String naturalidadeEstado) {
		this.naturalidadeEstado = naturalidadeEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLocalDeTrabalho() {
		return localDeTrabalho;
	}

	public void setLocalDeTrabalho(String localDeTrabalho) {
		this.localDeTrabalho = localDeTrabalho;
	}

	public String getVersaoDoEnvolvido() {
		return versaoDoEnvolvido;
	}

	public void setVersaoDoEnvolvido(String versaoDoEnvolvido) {
		this.versaoDoEnvolvido = versaoDoEnvolvido;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoEnd() {
		return estadoEnd;
	}

	public void setEstadoEnd(String estadoEnd) {
		this.estadoEnd = estadoEnd;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public String getEstadoRG() {
		return estadoRG;
	}

	public void setEstadoRG(String estadoRG) {
		this.estadoRG = estadoRG;
	}
}
