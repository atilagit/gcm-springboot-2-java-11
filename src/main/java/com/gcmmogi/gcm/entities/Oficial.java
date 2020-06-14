package com.gcmmogi.gcm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gcmmogi.gcm.entities.enums.Posto;

@Entity
@Table(name = "tb_oficial")
public class Oficial implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private String nome;
	private String time;
	private Integer viatura;
	
	private Integer posto;
	
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "oficial")
	private List<BoletimOcorrencia> boletins = new ArrayList<>();
	
	public Oficial() {
	}

	public Oficial(Long id, String login, String senha, String nome, String time, Integer viatura, Posto posto, String email) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.time = time;
		this.viatura = viatura;
		setPosto(posto);
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getViatura() {
		return viatura;
	}

	public void setViatura(Integer viatura) {
		this.viatura = viatura;
	}

	public Posto getPosto() {
		return Posto.valueOf(posto);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPosto(Posto posto) {
		if(posto != null) {
			this.posto = posto.getCode();
		}
	}
	
	public List<BoletimOcorrencia> getBoletins() {
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
		Oficial other = (Oficial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
