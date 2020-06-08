package com.gcmmogi.gcm.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_boletimOcorrencia")
public class BoletimOcorrencia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDaOcorrencia;
	private Instant data;
	private Instant horaFato;
	private Integer numTalao;
	private Integer viatura;
	private Instant horaDeIrradiacao;
	private Instant horaLocal;
	private String primeiroTermino;
	private String segundoTermino;
	private String kmDeIrradiacao;
	private String kmLocal;
	private String kmPrimeiroTermino;
	private String kmSegundoTermino;
	private String local;
	private String relatorioDaGCM;
	
	@ManyToOne
	@JoinColumn(name = "oficial_id")
	private Oficial oficial;
	
	public BoletimOcorrencia() {
	}

	public BoletimOcorrencia(Long id, Integer numeroDaOcorrencia, Instant data, Instant horaFato, Integer numTalao,
			Integer viatura, Instant horaDeIrradiacao, Instant horaLocal, String primeiroTermino, String segundoTermino,
			String kmDeIrradiacao, String kmLocal, String kmPrimeiroTermino, String kmSegundoTermino, String local,
			String relatorioDaGCM, Oficial oficial) {
		super();
		this.id = id;
		this.numeroDaOcorrencia = numeroDaOcorrencia;
		this.data = data;
		this.horaFato = horaFato;
		this.numTalao = numTalao;
		this.viatura = viatura;
		this.horaDeIrradiacao = horaDeIrradiacao;
		this.horaLocal = horaLocal;
		this.primeiroTermino = primeiroTermino;
		this.segundoTermino = segundoTermino;
		this.kmDeIrradiacao = kmDeIrradiacao;
		this.kmLocal = kmLocal;
		this.kmPrimeiroTermino = kmPrimeiroTermino;
		this.kmSegundoTermino = kmSegundoTermino;
		this.local = local;
		this.relatorioDaGCM = relatorioDaGCM;
		this.oficial = oficial;
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

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Instant getHoraFato() {
		return horaFato;
	}

	public void setHoraFato(Instant horaFato) {
		this.horaFato = horaFato;
	}

	public Integer getNumTalao() {
		return numTalao;
	}

	public void setNumTalao(Integer numTalao) {
		this.numTalao = numTalao;
	}

	public Integer getViatura() {
		return viatura;
	}

	public void setViatura(Integer viatura) {
		this.viatura = viatura;
	}

	public Instant getHoraDeIrradiacao() {
		return horaDeIrradiacao;
	}

	public void setHoraDeIrradiacao(Instant horaDeIrradiacao) {
		this.horaDeIrradiacao = horaDeIrradiacao;
	}

	public Instant getHoraLocal() {
		return horaLocal;
	}

	public void setHoraLocal(Instant horaLocal) {
		this.horaLocal = horaLocal;
	}

	public String getPrimeiroTermino() {
		return primeiroTermino;
	}

	public void setPrimeiroTermino(String primeiroTermino) {
		this.primeiroTermino = primeiroTermino;
	}

	public String getSegundoTermino() {
		return segundoTermino;
	}

	public void setSegundoTermino(String segundoTermino) {
		this.segundoTermino = segundoTermino;
	}

	public String getKmDeIrradiacao() {
		return kmDeIrradiacao;
	}

	public void setKmDeIrradiacao(String kmDeIrradiacao) {
		this.kmDeIrradiacao = kmDeIrradiacao;
	}

	public String getKmLocal() {
		return kmLocal;
	}

	public void setKmLocal(String kmLocal) {
		this.kmLocal = kmLocal;
	}

	public String getKmPrimeiroTermino() {
		return kmPrimeiroTermino;
	}

	public void setKmPrimeiroTermino(String kmPrimeiroTermino) {
		this.kmPrimeiroTermino = kmPrimeiroTermino;
	}

	public String getKmSegundoTermino() {
		return kmSegundoTermino;
	}

	public void setKmSegundoTermino(String kmSegundoTermino) {
		this.kmSegundoTermino = kmSegundoTermino;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getRelatorioDaGCM() {
		return relatorioDaGCM;
	}

	public void setRelatorioDaGCM(String relatorioDaGCM) {
		this.relatorioDaGCM = relatorioDaGCM;
	}

	public Oficial getOficial() {
		return oficial;
	}

	public void setOficial(Oficial oficial) {
		this.oficial = oficial;
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
		BoletimOcorrencia other = (BoletimOcorrencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
