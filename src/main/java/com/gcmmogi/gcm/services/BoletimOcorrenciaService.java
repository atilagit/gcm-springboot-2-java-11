package com.gcmmogi.gcm.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Envolvido;
import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.entities.VeiculoAveriguado;
import com.gcmmogi.gcm.entities.enums.CondicaoDaParte;
import com.gcmmogi.gcm.entities.enums.Dano;
import com.gcmmogi.gcm.repositories.BairroRepository;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;
import com.gcmmogi.gcm.repositories.EnvolvidoRepository;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;
import com.gcmmogi.gcm.repositories.VeiculoAveriguadoRepository;
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
	
	public List<BoletimOcorrencia> findAll(){
		return repository.findAll();
	}
	
	public BoletimOcorrencia findById(Long id) {
		Optional<BoletimOcorrencia> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
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
		
		Set<Ocorrencia> ocorrenciasOriundasDoBD = new HashSet<>();
		for (Ocorrencia o : obj.getOcorrencias()) {
			ocorrenciasOriundasDoBD.add(ocorrenciaService.findById(o.getId()));
		}
		obj.setOcorrencias(ocorrenciasOriundasDoBD);
		for (Ocorrencia o : ocorrenciasOriundasDoBD) {
			o.getBoletins().add(obj);
		}
		
		obj.setBairro(bairroService.findById(obj.getBairro().getId()));
		obj.getBairro().getBoletins().add(obj);
		
		obj.setOficial(oficialService.findById(obj.getOficial().getId()));
		obj.getOficial().getBoletins().add(obj);
				
		obj = repository.save(obj);
		envolvidoRepository.saveAll(obj.getEnvolvidos());
		veiculoAveriguadoRepository.saveAll(obj.getVeiculos());
		ocorrenciaRepository.saveAll(obj.getOcorrencias());
		bairroRepository.save(obj.getBairro());
		oficialRepository.save(obj.getOficial());
		
		return obj;
	}
}
