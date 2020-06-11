package com.gcmmogi.gcm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.services.OcorrenciaService;

@RestController
@RequestMapping(value = "/ocorrencias")
public class OcorrenciaResource {
	
	@Autowired
	private OcorrenciaService service;
	
	@GetMapping
	public ResponseEntity<List<Ocorrencia>> findAll(){
		List<Ocorrencia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ocorrencia> findById(@PathVariable Long id){
		Ocorrencia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
