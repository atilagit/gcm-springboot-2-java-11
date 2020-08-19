package com.gcmmogi.gcm.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Envolvido;
import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.entities.VeiculoAveriguado;
import com.gcmmogi.gcm.entities.enums.CondicaoDaParte;
import com.gcmmogi.gcm.entities.enums.Dano;
import com.gcmmogi.gcm.entities.enums.Perfil;
import com.gcmmogi.gcm.repositories.BairroRepository;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;
import com.gcmmogi.gcm.repositories.EnvolvidoRepository;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;
import com.gcmmogi.gcm.repositories.VeiculoAveriguadoRepository;
import com.gcmmogi.gcm.security.UserSS;
import com.gcmmogi.gcm.services.exceptions.AuthorizationException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class BoletimOcorrenciaService {
	
	@Autowired
	private BoletimOcorrenciaRepository repository;
	
	@Autowired
	private EnvolvidoRepository envolvidoRepository;
	
	@Autowired
	private VeiculoAveriguadoRepository veiculoAveriguadoRepository;
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired
	private OficialRepository oficialRepository;
	
	@Autowired
	private OcorrenciaService ocorrenciaService;
	
	@Autowired
	private BairroService bairroService;
	
	@Autowired
	private OficialService oficialService;
	
	@Autowired
	private EnvolvidoService envolvidoService;
	
	@Autowired
	private VeiculoAveriguadoService veiculoAveriguadoService;
	
	//UserSS user = UserService.authenticated();
	
	public List<BoletimOcorrencia> findAll(){
		return repository.findAll();
	}
	
	public List<BoletimOcorrencia> meusBoletins(){
		UserSS user = UserService.authenticated();
		if(user==null) throw new AuthorizationException("Acesso negado");
		Sort sort = Sort.by("id").descending();
		return repository.findFirst2ByOficial(oficialService.findById(user.getId()), sort);
	}
	
	public BoletimOcorrencia findById(Long id) {
		if(esteBoletimPertenceAoUsuario(id) || esteUsuarioEhAdministrador()) {
			Optional<BoletimOcorrencia> obj = repository.findById(id);
			return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		}
		throw new AuthorizationException("Acesso negado");
	}
	
	@Transactional
	public BoletimOcorrencia insert(BoletimOcorrencia obj) {
		obj.setId(null);
		
		for (Envolvido e : obj.getEnvolvidos()) {
			e.getBoletins().add(obj);
			e.setCondicaoDaParte((e.getCondicaoDaParte()==null) ? CondicaoDaParte.INDEFINIDA : e.getCondicaoDaParte());
			e.getEndereco().setEnvolvido(e);
			e.getRg().setEnvolvido(e);
		}
		
		for(VeiculoAveriguado va : obj.getVeiculos()) {
			va.getBoletins().add(obj);
			va.setDano((va.getDano()==null) ? Dano.SEM_DANO : va.getDano());
		}
		
		preencheEAssociaNovaOcorrencia(obj);
		preencheEAssociaNovoBairro(obj);
		preencheEAssociaNovoOficial(obj);
				
		obj = repository.save(obj);
		envolvidoRepository.saveAll(obj.getEnvolvidos());
		veiculoAveriguadoRepository.saveAll(obj.getVeiculos());
		ocorrenciaRepository.saveAll(obj.getOcorrencias());
		bairroRepository.save(obj.getBairro());
		oficialRepository.save(obj.getOficial());
		
		return obj;
	}
	
	@Transactional
	public BoletimOcorrencia update(Long id, BoletimOcorrencia obj) {
		if(!esteBoletimPertenceAoUsuario(id) && !esteUsuarioEhAdministrador()) 
			throw new AuthorizationException("Acesso negado");
		
		try {
			BoletimOcorrencia entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(BoletimOcorrencia entity, BoletimOcorrencia obj) {
		Set<Long> idsDeEnvolvidos = new HashSet<>();
		entity.getEnvolvidos().forEach(x -> idsDeEnvolvidos.add(x.getId()));
		
		Set<Long> idsDeVeiculos = new HashSet<>();
		entity.getVeiculos().forEach(x -> idsDeVeiculos.add(x.getId()));
		
		entity.setNumeroDaOcorrencia(obj.getNumeroDaOcorrencia());
		entity.setData(obj.getData());
		entity.setHoraFato(obj.getHoraFato());
		entity.setNumTalao(obj.getNumTalao());
		entity.setViatura(obj.getViatura());
		entity.setHoraDeIrradiacao(obj.getHoraDeIrradiacao());
		entity.setHoraLocal(obj.getHoraLocal());
		entity.setPrimeiroTermino(obj.getPrimeiroTermino());
		entity.setSegundoTermino(obj.getSegundoTermino());
		entity.setKmDeIrradiacao(obj.getKmDeIrradiacao());
		entity.setKmLocal(obj.getKmLocal());
		entity.setKmPrimeiroTermino(obj.getKmPrimeiroTermino());
		entity.setKmSegundoTermino(obj.getKmSegundoTermino());
		entity.setLocal(obj.getLocal());
		entity.setRelatorioDaGCM(obj.getRelatorioDaGCM());
		
		if(obj.getOcorrencias() != null) {
			entity.getOcorrencias().forEach(x -> x.getBoletins().remove(obj));
			ocorrenciaRepository.saveAll(entity.getOcorrencias());
			entity.getOcorrencias().addAll(obj.getOcorrencias()); //addAll(other) - união: adiciona no conjunto os elementos do outro conjunto, sem repetição
			entity.getOcorrencias().retainAll(obj.getOcorrencias()); //retainAll(other) - interseção: remove do conjunto os elementos não contidos em other
			obj.setOcorrencias(entity.getOcorrencias());
			preencheEAssociaNovaOcorrencia(obj);
			entity.setOcorrencias(obj.getOcorrencias());
		}
		
		if(obj.getBairro() != null) {
			entity.getBairro().getBoletins().remove(obj);
			bairroRepository.save(entity.getBairro());
			preencheEAssociaNovoBairro(obj);
			entity.setBairro(obj.getBairro());
		}
		
		if(obj.getOficial() != null && esteUsuarioEhAdministrador()) {
			entity.getOficial().getBoletins().remove(obj);
			oficialRepository.save(entity.getOficial());
			preencheEAssociaNovoOficial(obj);
			entity.setOficial(obj.getOficial());
		}
		
		if(obj.getEnvolvidos() != null) {
			entity.getEnvolvidos().forEach(x -> x.getBoletins().remove(obj));
			envolvidoRepository.saveAll(entity.getEnvolvidos());
			entity.getEnvolvidos().addAll(obj.getEnvolvidos()); //addAll(other) - união: adiciona no conjunto os elementos do outro conjunto, sem repetição
			entity.getEnvolvidos().retainAll(obj.getEnvolvidos()); //retainAll(other) - interseção: remove do conjunto os elementos não contidos em other
			obj.setEnvolvidos(entity.getEnvolvidos());
			preencheEAssociaNovosEnvolvidos(obj, idsDeEnvolvidos);
			entity.setEnvolvidos(obj.getEnvolvidos());
		}
		
		if(obj.getVeiculos() != null) {
			entity.getVeiculos().forEach(x -> x.getBoletins().remove(obj));
			veiculoAveriguadoRepository.saveAll(entity.getVeiculos());
			entity.getVeiculos().addAll(obj.getVeiculos()); //addAll(other) - união: adiciona no conjunto os elementos do outro conjunto, sem repetição
			entity.getVeiculos().retainAll(obj.getVeiculos()); //retainAll(other) - interseção: remove do conjunto os elementos não contidos em other
			obj.setVeiculos(entity.getVeiculos());
			preencheEAssociaNovosVeiculos(obj, idsDeVeiculos);
			entity.setVeiculos(obj.getVeiculos());
		}
	}

	private void preencheEAssociaNovaOcorrencia(BoletimOcorrencia obj) {
		Set<Ocorrencia> ocorrenciasOriundasDoBD = new HashSet<>();
		for (Ocorrencia o : obj.getOcorrencias()) {
			ocorrenciasOriundasDoBD.add(ocorrenciaService.findById(o.getId()));
		}
		obj.setOcorrencias(ocorrenciasOriundasDoBD);
		for (Ocorrencia o : ocorrenciasOriundasDoBD) {
			o.getBoletins().add(obj);
		}
	}

	private void preencheEAssociaNovoBairro(BoletimOcorrencia obj) {
		obj.setBairro(bairroService.findById(obj.getBairro().getId()));
		obj.getBairro().getBoletins().add(obj);
	}
	
	private void preencheEAssociaNovoOficial(BoletimOcorrencia obj) {
		obj.setOficial(oficialService.findById(obj.getOficial().getId()));
		obj.getOficial().getBoletins().add(obj);
	}
	
	private void preencheEAssociaNovosEnvolvidos(BoletimOcorrencia obj, Set<Long> ids) {
		Set<Envolvido> envolvidos = new HashSet<>();
		for (Envolvido e : obj.getEnvolvidos()) {
			if(e.getId() != null && ids.contains(e.getId())) {
				envolvidoService.update(e.getId(), e);
				envolvidos.add(envolvidoService.findById(e.getId()));
			}else {
				envolvidos.add(envolvidoService.insert(envolvidoService.fromDTO(envolvidoService.toDTO(e))));
			}
		}
		obj.setEnvolvidos(envolvidos);
		for (Envolvido e : envolvidos) {
			e.getBoletins().add(obj);
		}
	}
	
	private void preencheEAssociaNovosVeiculos(BoletimOcorrencia obj, Set<Long> ids) {
		Set<VeiculoAveriguado> veiculos = new HashSet<>();
		for (VeiculoAveriguado v : obj.getVeiculos()) {
			if(v.getId() != null && ids.contains(v.getId())) {
				veiculoAveriguadoService.update(v.getId(), v);
				veiculos.add(veiculoAveriguadoService.findById(v.getId()));
			}else {
				veiculos.add(veiculoAveriguadoService.insert(v));
			}
		}
		obj.setVeiculos(veiculos);
		for (VeiculoAveriguado v : veiculos) {
			v.getBoletins().add(obj);
		}
	}
		
	private boolean esteBoletimPertenceAoUsuario(Long idDoBoletim) {
		UserSS user = UserService.authenticated();
		Optional<BoletimOcorrencia> obj = repository.findById(idDoBoletim);
		return obj.get().getOficial().getId().equals(user.getId());
	}
	
	private boolean esteUsuarioEhAdministrador() {
		UserSS user = UserService.authenticated();
		return user.hasRole(Perfil.ADMINISTRATIVO);
	}
}
