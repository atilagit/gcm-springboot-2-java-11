package com.gcmmogi.gcm.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	private String dataNascimento;
	
	private String pai;
	private String mae;
	private String nacionalidade;
	private String naturalidadeCidade;
	private String naturalidadeEstado;
	private String telefone;
	private String localDeTrabalho;
	
	@Column(columnDefinition = "TEXT")
	private String versaoDoEnvolvido;

	@OneToOne(mappedBy = "envolvido", cascade = CascadeType.ALL)
	private RG rg;

	@OneToOne(mappedBy = "envolvido", cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "envolvidos")
	private Set<BoletimOcorrencia> boletins = new HashSet<>();

	public Envolvido() {
	}

	public Envolvido(Long id, CondicaoDaParte condicaoDaParte, Boolean conduzido, String nome, String dataNascimento,
			String pai, String mae, String nacionalidade, String naturalidadeCidade, String naturalidadeEstado,
			String telefone, String localDeTrabalho, String versaoDoEnvolvido) {
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
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
		result = prime * result + ((condicaoDaParte == null) ? 0 : condicaoDaParte.hashCode());
		result = prime * result + ((conduzido == null) ? 0 : conduzido.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localDeTrabalho == null) ? 0 : localDeTrabalho.hashCode());
		result = prime * result + ((mae == null) ? 0 : mae.hashCode());
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((naturalidadeCidade == null) ? 0 : naturalidadeCidade.hashCode());
		result = prime * result + ((naturalidadeEstado == null) ? 0 : naturalidadeEstado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((versaoDoEnvolvido == null) ? 0 : versaoDoEnvolvido.hashCode());
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
		if (condicaoDaParte == null) {
			if (other.condicaoDaParte != null)
				return false;
		} else if (!condicaoDaParte.equals(other.condicaoDaParte))
			return false;
		if (conduzido == null) {
			if (other.conduzido != null)
				return false;
		} else if (!conduzido.equals(other.conduzido))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localDeTrabalho == null) {
			if (other.localDeTrabalho != null)
				return false;
		} else if (!localDeTrabalho.equals(other.localDeTrabalho))
			return false;
		if (mae == null) {
			if (other.mae != null)
				return false;
		} else if (!mae.equals(other.mae))
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (naturalidadeCidade == null) {
			if (other.naturalidadeCidade != null)
				return false;
		} else if (!naturalidadeCidade.equals(other.naturalidadeCidade))
			return false;
		if (naturalidadeEstado == null) {
			if (other.naturalidadeEstado != null)
				return false;
		} else if (!naturalidadeEstado.equals(other.naturalidadeEstado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (versaoDoEnvolvido == null) {
			if (other.versaoDoEnvolvido != null)
				return false;
		} else if (!versaoDoEnvolvido.equals(other.versaoDoEnvolvido))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String[] vect = nome.split(" ");
		return vect[0] + "(" + CondicaoDaParte.valueOf(condicaoDaParte) + ")";
	}
}
