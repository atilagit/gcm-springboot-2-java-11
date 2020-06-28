package com.gcmmogi.gcm.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.dto.BairroDTO;
import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;
import com.gcmmogi.gcm.services.exceptions.DatabaseException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class OcorrenciaService {
	
	@Autowired
	private OcorrenciaRepository repository;
	
	public List<Ocorrencia> findAll(){
		return repository.findAll();
	}
	
	public Ocorrencia findById(Long id) {
		Optional<Ocorrencia> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Ocorrencia insert(Ocorrencia obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Ocorrencia update(Long id, Ocorrencia obj) {
		try {
			Ocorrencia entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public List<BairroDTO> indicadoresPorOcorrencia(Long id) { 
		Integer top = 3; //o top indica quantos elementos a lista vai retornar
		Ocorrencia ocorrencia = findById(id);
		List<Bairro> todosBairrosComRepetição = todosBairros(ocorrencia);
		Integer totalDeBairros = todosBairrosComRepetição.size();
		Map<Bairro, Integer> map = deListParaMap(todosBairrosComRepetição);
		List<BairroDTO> list = deMapParaListDto(map, totalDeBairros);
		list.sort((b1,b2) -> b2.getQuantidade() - b1.getQuantidade());
		list.removeIf(x -> list.indexOf(x) > top-1);
		return list;
	}

	private void updateData(Ocorrencia entity, Ocorrencia obj) {
		entity.setCodigoDaOcorrencia(obj.getCodigoDaOcorrencia());
		entity.setNaturezaDaOcorrencia(obj.getNaturezaDaOcorrencia());
	}
	
	private List<Bairro> todosBairros(Ocorrencia ocorrencia) {
		List<Bairro> todosBairrosComRepetição = new ArrayList<>();
		Set<BoletimOcorrencia> boletinsDaOcorrencia = ocorrencia.getBoletins();
		for (BoletimOcorrencia bo : boletinsDaOcorrencia) {
			todosBairrosComRepetição.add(bo.getBairro());
		}
		return todosBairrosComRepetição;
	}

	private List<BairroDTO> deMapParaListDto(Map<Bairro, Integer> map, Integer totalDeBairros) {
		List<BairroDTO> list = new ArrayList<>();
		for(Bairro key : map.keySet()) {
			Double percentual = Double.parseDouble(String.format(Locale.US, "%.1f", ((map.get(key).doubleValue() / totalDeBairros.doubleValue()) * 100)));
			list.add(new BairroDTO(key.getNome(), map.get(key), percentual));
		}
		return list;
	}
	
	private Map<Bairro, Integer> deListParaMap(List<Bairro> bairros) {
		Map<Bairro, Integer> bairrosSemRepeticao = new HashMap<>();
		for(Bairro b : bairros) {
			Integer quant = 1;
			if(!bairrosSemRepeticao.containsKey(b)) {
				bairrosSemRepeticao.put(b, quant);
			}else {
				quant = bairrosSemRepeticao.get(b) + 1;
				bairrosSemRepeticao.put(b, quant);
			}
		}
		return bairrosSemRepeticao;
	}
}
