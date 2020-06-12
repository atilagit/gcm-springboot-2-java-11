package com.gcmmogi.gcm.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gcmmogi.gcm.entities.enums.CondicaoDaParte;

@Entity
@Table(name = "tb_envolvido")
public class Envolvido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer condicaoDaParte;
	private Boolean conduzido;
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataNascimento;
	
	private String pai;
	private String mae;
	private String nacionalidade;
	private String naturalidadeCidade;
	private String naturalidadeEstado;
	private String telefone;
	private String localDeTrabalho;
	private String versaoDoEnvolvido;

	@OneToOne(mappedBy = "envolvido", cascade = CascadeType.ALL)
	private RG rg;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "envolvidos")
	private Set<BoletimOcorrencia> boletins = new HashSet<>();

	public Envolvido() {
	}

	public Envolvido(Long id, CondicaoDaParte condicaoDaParte, Boolean conduzido, String nome, Instant dataNascimento,
			String pai, String mae, String nacionalidade, String naturalidadeCidade, String naturalidadeEstado,
			String telefone, String localDeTrabalho, String versaoDoEnvolvido, RG rg, Endereco endereco) {
		super();
		this.id = id;
		setCondicaoDaParte(condicaoDaParte);
		this.conduzido = conduzido;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.pai = pai;
		this.mae = mae;
		this.nacionalidade = nacionalidade;
		this.naturalidadeCidade = naturalidadeCidade;
		this.naturalidadeEstado = naturalidadeEstado;
		this.telefone = telefone;
		this.localDeTrabalho = localDeTrabalho;
		this.versaoDoEnvolvido = versaoDoEnvolvido;
		this.rg = rg;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CondicaoDaParte getCondicaoDaParte() {
		return CondicaoDaParte.valueOf(condicaoDaParte);
	}

	public void setCondicaoDaParte(CondicaoDaParte condicaoDaParte) {
		if(condicaoDaParte != null) {
			this.condicaoDaParte = condicaoDaParte.getCode();
		}
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

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Set<BoletimOcorrencia> getBoletins() {
		return boletins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Envolvido other = (Envolvido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
