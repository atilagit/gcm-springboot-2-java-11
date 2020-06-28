package com.gcmmogi.gcm.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_boletimDeOcorrencia")
public class BoletimOcorrencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDaOcorrencia;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private String data;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private String horaFato;

	private Integer numTalao;
	private Integer viatura;

	private String horaDeIrradiacao;
	private String horaLocal;
	private String primeiroTermino;
	private String segundoTermino;

	private Integer kmDeIrradiacao;
	private Integer kmLocal;
	private Integer kmPrimeiroTermino;
	private Integer kmSegundoTermino;
	private String local;
	private String relatorioDaGCM;

	@ManyToOne
	@JoinColumn(name = "oficial_id")
	private Oficial oficial;

	@ManyToOne
	@JoinColumn(name = "bairro_id")
	private Bairro bairro;

	@ManyToMany
	@JoinTable(name = "tb_boletim_ocorrencia", joinColumns = @JoinColumn(name = "boletim_id"), inverseJoinColumns = @JoinColumn(name = "ocorrencia_id"))
	private Set<Ocorrencia> ocorrencias = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "tb_boletim_veiculo", joinColumns = @JoinColumn(name = "boletim_id"), inverseJoinColumns = @JoinColumn(name = "veiculo_id"))
	private Set<VeiculoAveriguado> veiculos = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_boletim_envolvido", joinColumns = @JoinColumn(name = "boletim_id"), inverseJoinColumns = @JoinColumn(name = "envolvido_id"))
	private Set<Envolvido> envolvidos = new HashSet<>();

	public BoletimOcorrencia() {
	}

	public BoletimOcorrencia(Long id, Integer numeroDaOcorrencia, String data, String horaFato, Integer numTalao,
			Integer viatura, String horaDeIrradiacao, String horaLocal, String primeiroTermino,
			String segundoTermino, Integer kmDeIrradiacao, Integer kmLocal, Integer kmPrimeiroTermino,
			Integer kmSegundoTermino, String local, String relatorioDaGCM, Oficial oficial, Bairro bairro) {
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
		this.bairro = bairro;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraFato() {
		return horaFato;
	}

	public void setHoraFato(String horaFato) {
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

	public String getHoraDeIrradiacao() {
		return horaDeIrradiacao;
	}

	public void setHoraDeIrradiacao(String horaDeIrradiacao) {
		this.horaDeIrradiacao = horaDeIrradiacao;
	}

	public String getHoraLocal() {
		return horaLocal;
	}

	public void setHoraLocal(String horaLocal) {
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

	public Integer getKmDeIrradiacao() {
		return kmDeIrradiacao;
	}

	public void setKmDeIrradiacao(Integer kmDeIrradiacao) {
		this.kmDeIrradiacao = kmDeIrradiacao;
	}

	public Integer getKmLocal() {
		return kmLocal;
	}

	public void setKmLocal(Integer kmLocal) {
		this.kmLocal = kmLocal;
	}

	public Integer getKmPrimeiroTermino() {
		return kmPrimeiroTermino;
	}

	public void setKmPrimeiroTermino(Integer kmPrimeiroTermino) {
		this.kmPrimeiroTermino = kmPrimeiroTermino;
	}

	public Integer getKmSegundoTermino() {
		return kmSegundoTermino;
	}

	public void setKmSegundoTermino(Integer kmSegundoTermino) {
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

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	public Set<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(Set<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Set<VeiculoAveriguado> getVeiculos() {
		return veiculos;
	}
	
	public void setVeiculos(Set<VeiculoAveriguado> veiculos) {
		this.veiculos = veiculos;
	}

	public Set<Envolvido> getEnvolvidos() {
		return envolvidos;
	}
	
	public void setEnvolvidos(Set<Envolvido> envolvidos) {
		this.envolvidos = envolvidos;
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
